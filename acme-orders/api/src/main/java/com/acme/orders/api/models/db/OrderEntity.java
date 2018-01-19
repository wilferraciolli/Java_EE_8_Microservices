package com.acme.orders.api.models.db;

import com.acme.orders.api.models.db.common.BaseEntity;
import com.acme.orders.lib.v1.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * The type Order entity. Order entity bean to map an order to the table.
 */
@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "OrderEntity.findAll", query = "SELECT o FROM OrderEntity o"),
        @NamedQuery(name = "OrderEntity.findAllCount", query = "SELECT count(o) FROM OrderEntity o")
})
public class OrderEntity extends BaseEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @NotNull
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "transaction_id")
    private String transactionId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItemEntity> cart;

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

    /**
     * Gets cart.
     *
     * @return the cart
     */
    public Set<OrderItemEntity> getCart() {
        return cart;
    }

    /**
     * Sets cart.
     *
     * @param cart the cart
     */
    public void setCart(Set<OrderItemEntity> cart) {
        this.cart = cart;
    }
}
