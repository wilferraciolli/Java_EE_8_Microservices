package com.acme.orders.lib.v1;

import com.acme.orders.lib.v1.common.BaseType;

import java.util.List;
import java.util.Set;

/**
 * The type Order. Entity class to map an order.
 */
public class Order extends BaseType {

    private OrderStatus status;
    private Set<OrderItem> cart;
    private String customerId;
    private String transactionId;

    /**
     * Gets status.
     *
     * @return the status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    /**
     * Gets cart.
     *
     * @return the cart
     */
    public Set<OrderItem> getCart() {
        return cart;
    }

    /**
     * Sets cart.
     *
     * @param cart the cart
     */
    public void setCart(Set<OrderItem> cart) {
        this.cart = cart;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets transaction id.
     *
     * @return the transaction id
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets transaction id.
     *
     * @param transactionId the transaction id
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
