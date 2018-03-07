/**
 * (c) Midland Software Limited 2018
 * Name     : PaymentsClient.java
 * Author   : ferraciolliw
 * Date     : 07 Mar 2018
 */
package com.acme.orders.api.integrations;

import com.acme.orders.api.models.db.OrderEntity;
import com.acme.payments.lib.Transaction;

/**
 * The interface Payments client.  This is to integrate with Payments Microservice.
 */
public interface PaymentsClient {

    /**
     * Create transaction transaction.
     * @param orderEntity the order entity
     * @return the transaction
     */
    Transaction createTransaction(OrderEntity orderEntity);
}
