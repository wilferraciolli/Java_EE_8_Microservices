package com.acme.orders.api.mapper;

import com.acme.orders.api.models.db.OrderEntity;
import com.acme.orders.api.models.db.OrderItemEntity;
import com.acme.orders.lib.v1.Order;
import com.acme.orders.lib.v1.OrderItem;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Order mapper. Utility class to map Order to entity and TO.
 */
public class OrderMapper {

    /**
     * To order order.
     *
     * @param entity the entity
     * @return the order
     */
    public static Order toOrder(OrderEntity entity) {

        if (entity == null) return null;

        Order order = new Order();
        order.setId(entity.getId());
        order.setCreatedAt(entity.getCreatedAt());
        order.setUpdatedAt(entity.getUpdatedAt());
        order.setCustomerId(entity.getCustomerId());
        order.setTransactionId(entity.getTransactionId());
        order.setStatus(entity.getStatus());

        if (entity.getCart() != null && !entity.getCart().isEmpty()) {

            Set<OrderItem> items = new HashSet<>();

            for (OrderItemEntity itemEntity : entity.getCart()) {

                OrderItem orderItem = new OrderItem();
                orderItem.setId(itemEntity.getId());
                orderItem.setCreatedAt(itemEntity.getCreatedAt());
                orderItem.setUpdatedAt(itemEntity.getUpdatedAt());
                orderItem.setTitle(itemEntity.getTitle());
                orderItem.setAmount(itemEntity.getAmount());
                orderItem.setCurrency(itemEntity.getCurrency());
                orderItem.setPrice(itemEntity.getPrice());
                orderItem.setQuantity(itemEntity.getQuantity());
                orderItem.setProductId(itemEntity.getProductId());

                items.add(orderItem);
            }

            order.setCart(items);
        }

        return order;
    }

    /**
     * To order entity order entity.
     *
     * @param order the order
     * @return the order entity
     */
    public static OrderEntity toOrderEntity(Order order) {

        if (order == null) return null;

        OrderEntity entity = new OrderEntity();
        entity.setCustomerId(order.getCustomerId());

        if (order.getCart() != null && !order.getCart().isEmpty()) {

            Set<OrderItemEntity> items = new HashSet<>();

            for (OrderItem item : order.getCart()) {

                OrderItemEntity orderItemEntity = new OrderItemEntity();
                orderItemEntity.setAmount(item.getAmount());
                orderItemEntity.setQuantity(item.getQuantity());
                orderItemEntity.setProductId(item.getProductId());
                orderItemEntity.setOrder(entity);

                items.add(orderItemEntity);
            }

            entity.setCart(items);
        }

        return entity;
    }
}
