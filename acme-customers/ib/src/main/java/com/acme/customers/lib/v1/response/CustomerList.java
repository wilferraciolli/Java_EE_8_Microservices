package com.acme.customers.lib.v1.response;

import com.acme.customers.lib.v1.Customer;

import java.util.List;

/**
 * The type Customer list.
 */
public class CustomerList {

    private List<Customer> customers;

    /**
     * Gets customers.
     *
     * @return the customers
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * Sets customers.
     *
     * @param customers the customers
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
