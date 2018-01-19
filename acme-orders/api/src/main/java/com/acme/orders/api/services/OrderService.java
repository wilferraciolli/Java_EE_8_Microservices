package com.acme.orders.api.services;

import com.acme.orders.lib.v1.Order;

import java.util.List;

/**
 * The interface Order service. This interface defines the methods to be implemented by the application Business Service.
 */
public interface OrderService {

    /**
     * Find order by id order.
     *
     * @param id the id
     * @return the order
     */
    Order findOrderById(String id);

    /**
     * Find orders list.
     *
     * @param limit  the limit
     * @param offset the offset
     * @return the list
     */
    List<Order> findOrders(Integer limit, Integer offset);

    /**
     * Find orders count long.
     *
     * @return the long
     */
    Long findOrdersCount();

    /**
     * Create order order.
     *
     * @param order the order
     * @return the order
     */
    Order createOrder(Order order);

    /**
     * Complete order order.
     *
     * @param id the id
     * @return the order
     */
    Order completeOrder(String id);

    /**
     * Cancel order order.
     *
     * @param id the id
     * @return the order
     */
    Order cancelOrder(String id);
}
