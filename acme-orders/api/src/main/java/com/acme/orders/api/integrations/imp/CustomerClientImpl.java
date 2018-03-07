/**
 * (c) Midland Software Limited 2018
 * Name     : CustomerClientImpl.java
 * Author   : ferraciolliw
 * Date     : 12 Feb 2018
 */
package com.acme.orders.api.integrations.imp;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.acme.orders.api.integrations.CustomerClient;
import com.acme.orders.api.integrations.lib.catalogue.Customer;
import com.acme.orders.api.rest.v1.providers.JacksonProvider;
import com.acme.orders.api.services.exceptions.ResourceNotFoundException;
import com.acme.orders.lib.v1.common.ApiError;

/**
 * The type Customer client implementation.
 */
public class CustomerClientImpl implements CustomerClient {

    private WebTarget webTarget;

    /**
     * Instantiates a new Customer client.
     * @param client the client
     * @param customersUrl the customers url
     */
    public CustomerClientImpl(Client client, String customersUrl) {
        //instantiate a new Customer client
        this.webTarget = client.target(customersUrl).register(JacksonProvider.class);
    }

    @Override public Customer findCustomerById(final String id) {
        //try to get a customer from the customers micro service using a web client
        try {
            return webTarget.path("customers").path(id).request(MediaType.APPLICATION_JSON_TYPE)
                    .header("Authorization", "1234")
                    .get(Customer.class);

        } catch (WebApplicationException e) {
            //catch the error type
            ApiError error = e.getResponse().readEntity(ApiError.class);

            switch (error.getStatus()) {
            case 404:
                throw new ResourceNotFoundException(Customer.class.getSimpleName(), id);
            }

            throw e;
        }
    }
}
