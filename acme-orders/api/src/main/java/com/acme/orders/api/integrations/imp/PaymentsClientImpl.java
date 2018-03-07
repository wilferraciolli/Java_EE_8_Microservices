/**
 * (c) Midland Software Limited 2018
 * Name     : PaymentsClientImpl.java
 * Author   : ferraciolliw
 * Date     : 07 Mar 2018
 */
package com.acme.orders.api.integrations.imp;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.acme.orders.api.integrations.PaymentsClient;
import com.acme.orders.api.models.db.OrderEntity;
import com.acme.orders.api.models.db.OrderItemEntity;
import com.acme.payments.lib.Transaction;

/**
 * The type Payments client implementation.
 */
public class PaymentsClientImpl implements PaymentsClient {

    private WebTarget webTarget;

    public PaymentsClientImpl(final Client client, String baseUrl) {
        this.webTarget = client.target(baseUrl);
    }

    @Override
   public Transaction createTransaction(final OrderEntity orderEntity) {
        Transaction transaction = new Transaction();
        transaction.setNonce("TEST");
        transaction.setCurrency("EUR");
        transaction.setCustomerId(orderEntity.getCustomerId());
        transaction.setOrderId(orderEntity.getId());
        transaction.setAmount(orderEntity.getCart().stream()
                .map(OrderItemEntity::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));

        return webTarget.path("transactions").request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(transaction), Transaction.class);
    }
}
