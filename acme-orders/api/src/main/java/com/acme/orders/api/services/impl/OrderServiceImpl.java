package com.acme.orders.api.services.impl;

import com.acme.orders.api.mapper.OrderMapper;
import com.acme.orders.api.models.OrderDAO;
import com.acme.orders.api.models.db.OrderEntity;
import com.acme.orders.api.services.OrderService;
import com.acme.orders.api.services.exceptions.EmptyPayloadException;
import com.acme.orders.api.services.exceptions.OrderServiceException;
import com.acme.orders.api.services.exceptions.ResourceNotFoundException;
import com.acme.orders.lib.v1.Order;
import com.acme.orders.lib.v1.OrderStatus;
import com.acme.orders.lib.v1.common.OrderServiceErrorCode;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Order service implementation.
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    /**
     * Instantiates a new Order service.
     *
     * @param orderDAO the order dao
     */
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
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
     *
     * @param order the order
     * @return the order
     */
    @Override
    public Order createOrder(Order order) {

        //check order is null
        if (order == null) {
            throw new EmptyPayloadException(Order.class.getSimpleName());
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

        //persist to the database
        orderDAO.create(orderEntity);

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

        try {
            //this will call the pay service later on
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {
        }

        orderEntity.setStatus(OrderStatus.COMPLETED);

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

        return OrderMapper.toOrder(orderEntity);
    }
}
