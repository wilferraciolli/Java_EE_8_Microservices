/**
 * (c) Midland Software Limited 2018
 * Name     : CustomerClient.java
 * Author   : ferraciolliw
 * Date     : 12 Feb 2018
 */
package com.acme.orders.api.integrations;

import com.acme.orders.api.integrations.lib.catalogue.Customer;

/**
 * The interface Customer client. This is to integrate with Customer Microservice.
 */
public interface CustomerClient {

    /**
     * Find customer by id customer. This method is to find a customer
     * @param id the id
     * @return the customer
     */
    Customer findCustomerById(String id);
}
