package com.acme.orders.api.services.impl;

import com.acme.orders.api.integrations.CatalogueClient;
import com.acme.orders.api.integrations.CustomerClient;
import com.acme.orders.api.integrations.PaymentsClient;
import com.acme.orders.api.integrations.lib.catalogue.Product;
import com.acme.orders.api.mapper.OrderMapper;
import com.acme.orders.api.models.OrderDAO;
import com.acme.orders.api.models.db.OrderEntity;
import com.acme.orders.api.models.db.OrderItemEntity;
import com.acme.orders.api.services.OrderService;
import com.acme.orders.api.services.exceptions.EmptyPayloadException;
import com.acme.orders.api.services.exceptions.OrderServiceException;
import com.acme.orders.api.services.exceptions.ResourceNotFoundException;
import com.acme.orders.lib.v1.Order;
import com.acme.orders.lib.v1.OrderStatus;
import com.acme.orders.lib.v1.common.OrderServiceErrorCode;
import com.acme.payments.lib.Transaction;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * Order service implementation.
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    //Add client to get resource from another microservice
    private CustomerClient customerClient;
    private CatalogueClient catalogueClient;
    private PaymentsClient paymentsClient;

    //Add custom Metrics
    private Meter createMeter;
    private Meter completeMeter;
    private Meter canceledMeter;

    //create counter to process transactions
    private Counter processingCounter;
    private Histogram cartHistogram;

    /**
     * Instantiates a new Order service.
     * @param orderDAO the order dao
     * @param metricRegistry the metric registry
     * @param customerClient the customer client
     * @param catalogueClient the catalogue client
     */
    public OrderServiceImpl(OrderDAO orderDAO, MetricRegistry metricRegistry,
            CustomerClient customerClient,
            CatalogueClient catalogueClient,
            PaymentsClient paymentsClient) {

        //instantiate the dependencies
        this.orderDAO = orderDAO;
        this.customerClient = customerClient;
        this.catalogueClient = catalogueClient;
        this.paymentsClient = paymentsClient;

        //instantiate the metrics
        this.createMeter = metricRegistry.meter(OrderServiceImpl.class.getName() + ".create-order");
        this.completeMeter = metricRegistry.meter(OrderServiceImpl.class.getName() + ".complete-order");
        this.canceledMeter = metricRegistry.meter(OrderServiceImpl.class.getName() + ".cancel-order");

        //instantiate histogram
        this.processingCounter = metricRegistry.counter(OrderServiceImpl.class.getName() + ".orders-processing");
        this.cartHistogram = metricRegistry.histogram(OrderServiceImpl.class.getName() + ".orders-cart");
    }

    @Override
    public Order findOrderById(String id) {
        OrderEntity orderEntity = orderDAO.findById(id);

        if (orderEntity == null) {
            throw new ResourceNotFoundException(Order.class.getSimpleName(), id);
        }

        return OrderMapper.toOrder(orderEntity);
    }

    @Override
    public List<Order> findOrders(Integer limit, Integer offset) {

        List<OrderEntity> orderEntities = orderDAO.findAll(limit, offset);

        return orderEntities.stream().map(OrderMapper::toOrder).collect(Collectors.toList());
    }

    @Override
    public Long findOrdersCount() {
        return orderDAO.findAllCount();
    }

    /**
     * Create order order.
     * @param order the order
     * @return the order
     */
    @Override
    public Order createOrder(Order order) {

        //check order is null
        if (Objects.isNull(order)) {
            throw new EmptyPayloadException(Order.class.getSimpleName());
        }

        //check for the customer on the customer micro service
        if (StringUtils.isNotBlank(order.getCustomerId())) {
            customerClient.findCustomerById(order.getCustomerId());
        }

        //check cart is null
        if (order.getCart() == null || order.getCart().isEmpty()) {
            throw new OrderServiceException(OrderServiceErrorCode.ORDER_CART_EMPTY);
        }

        Date date = Date.from(Instant.now());

        OrderEntity orderEntity = OrderMapper.toOrderEntity(order);
        orderEntity.setId(null);
        orderEntity.setUpdatedAt(date);
        orderEntity.setCreatedAt(date);
        orderEntity.setStatus(OrderStatus.NEW);

        //validate each product on the cart
        for (OrderItemEntity orderItemEntity : orderEntity.getCart()) {
            //call the service to load a product
            Product product = catalogueClient.findByProductId(orderItemEntity.getProductId());

            orderItemEntity.setTitle(product.getTitle());
            orderItemEntity.setCurrency(product.getCurrency());
            orderItemEntity.setPrice(product.getPrice());

            //get the order quantity or assumes it is 1
            BigDecimal quantity = orderItemEntity.getQuantity() != null ? orderItemEntity.getQuantity() : BigDecimal.ONE;

            orderItemEntity.setQuantity( quantity);
            orderItemEntity.setAmount(product.getPrice().multiply(quantity));
        }

        //persist to the database
        orderDAO.create(orderEntity);

        //add as metric
        createMeter.mark();

        //update histogram
        cartHistogram.update(orderEntity.getCart().size());

        return OrderMapper.toOrder(orderEntity);
    }

    @Override
    public Order completeOrder(String id) {

        OrderEntity orderEntity = orderDAO.findById(id);

        if (orderEntity == null) {
            throw new ResourceNotFoundException(Order.class.getSimpleName(), id);
        }

        if (!orderEntity.getStatus().equals(OrderStatus.NEW)) {
            throw new OrderServiceException(OrderServiceErrorCode.ORDER_STATE_INCORRECT);
        }

        //mark the transaction as processing
        processingCounter.inc();

        //call payments micro service to complete the order
        Transaction transaction = paymentsClient.createTransaction(orderEntity);

        //set the transaction to finish
        processingCounter.dec();

        orderEntity.setStatus(OrderStatus.COMPLETED);
        //save the id of the transaction on the order so it can be queried later on
        orderEntity.setTransactionId(transaction.getId());

        //add as metric
        completeMeter.mark();

        return OrderMapper.toOrder(orderEntity);
    }

    @Override
    public Order cancelOrder(String id) {

        OrderEntity orderEntity = orderDAO.findById(id);

        if (orderEntity == null) {
            throw new ResourceNotFoundException(Order.class.getSimpleName(), id);
        }

        if (!orderEntity.getStatus().equals(OrderStatus.NEW)) {
            throw new OrderServiceException(OrderServiceErrorCode.ORDER_STATE_INCORRECT);
        }

        orderEntity.setStatus(OrderStatus.CANCELED);

        //add as metric
        canceledMeter.mark();

        return OrderMapper.toOrder(orderEntity);
    }
}
