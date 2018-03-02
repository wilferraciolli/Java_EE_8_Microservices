/**
 * (c) Midland Software Limited 2018
 * Name     : OderDAOtest.java
 * Author   : ferraciolliw
 * Date     : 02 Mar 2018
 */
package com.acme.orders.api.tests;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.acme.orders.api.models.OrderDAO;
import com.acme.orders.api.models.db.OrderEntity;
import com.acme.orders.api.models.db.OrderItemEntity;
import com.codahale.metrics.MetricRegistry;
import com.acme.orders.api.models.OrderDAO;
import com.acme.orders.api.models.db.OrderEntity;
import com.acme.orders.api.models.db.OrderItemEntity;
import com.acme.orders.lib.v1.OrderStatus;
import com.codahale.metrics.MetricRegistry;
import io.dropwizard.testing.junit.DAOTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.mock;

import io.dropwizard.testing.junit.DAOTestRule;

/**
 * The type Oder da otest.
 */
public class OderDAOtest {

    /**
     * Dropwizard to instantiate a database mock.
     */
    @Rule
    public DAOTestRule database = DAOTestRule.newBuilder()
            .addEntityClass(OrderEntity.class)
            .addEntityClass(OrderItemEntity.class)
            .build();

    private OrderDAO orderDAO;

    /**
     * Set up. mock metrics
     */
    @Before
    public void setUp(){
        orderDAO = new OrderDAO(database.getSessionFactory(), mock(MetricRegistry.class));
    }

    /**
     * Test create order.
     */
    @Test
    public void testCreateOrder(){
        Date date = Date.from(Instant.now());

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUpdatedAt(date);
        orderEntity.setCreatedAt(date);
        orderEntity.setStatus(OrderStatus.NEW);
        orderEntity.setCustomerId("4b1d5a5a-ae54-4816-b5c4-3bd5c98aa8f8");

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setProductId("1234");
        orderItemEntity.setQuantity(new BigDecimal("1"));
        orderItemEntity.setOrder(orderEntity);

        Set<OrderItemEntity> orderItemEntities = new HashSet<>();
        orderItemEntities.add(orderItemEntity);
        orderEntity.setCart(orderItemEntities);

        OrderEntity newOrderEntity = database.inTransaction(() -> orderDAO.create(orderEntity));

        assertThat(newOrderEntity.getId(), notNullValue());
    }
}
