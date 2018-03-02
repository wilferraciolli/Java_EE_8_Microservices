package com.acme.orders.api.tests;

import com.acme.orders.api.integrations.CatalogueClient;
import com.acme.orders.api.integrations.CustomerClient;
import com.acme.orders.api.models.OrderDAO;
import com.acme.orders.api.models.db.OrderEntity;
import com.acme.orders.api.models.db.OrderItemEntity;
import com.acme.orders.api.services.impl.OrderServiceImpl;
import com.acme.orders.lib.v1.Order;
import com.acme.orders.lib.v1.OrderStatus;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The type Order service impl test.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderDAO orderDAOMock;

    @Mock
    private CustomerClient customersClientMock;

    @Mock
    private CatalogueClient catalogueClientMock;

    @Mock
    private MetricRegistry metricRegistryMock;

    @Mock
    private Meter meterMock;

    @Mock
    private Counter counterMock;

    @Mock
    private Histogram histogramMock;

    /**
     * Sets .
     */
    @Before
    public void setup() {

        Date date = Date.from(Instant.now());

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setProductId("1234");
        orderItemEntity.setQuantity(new BigDecimal("1"));

        Set<OrderItemEntity> orderItemEntities = new HashSet<>();
        orderItemEntities.add(orderItemEntity);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId("9f099726-b0eb-4d1c-9459-76b7a8ac96f4");
        orderEntity.setUpdatedAt(date);
        orderEntity.setCreatedAt(date);
        orderEntity.setStatus(OrderStatus.NEW);
        orderEntity.setCustomerId("4b1d5a5a-ae54-4816-b5c4-3bd5c98aa8f8");
        orderEntity.setCart(orderItemEntities);

        when(orderDAOMock.findById("9f099726-b0eb-4d1c-9459-76b7a8ac96f4")).thenReturn(orderEntity);
    }

    /**
     * Tear down.
     */
    @After
    public void tearDown() {
        reset(orderDAOMock);
    }

    /**
     * Test find order by id.
     */
    @Test
    public void testFindOrderById() {

        Order order = orderService.findOrderById("9f099726-b0eb-4d1c-9459-76b7a8ac96f4");

        verify(orderDAOMock).findById("9f099726-b0eb-4d1c-9459-76b7a8ac96f4");

        assertThat(order, is(not(nullValue())));
    }
}