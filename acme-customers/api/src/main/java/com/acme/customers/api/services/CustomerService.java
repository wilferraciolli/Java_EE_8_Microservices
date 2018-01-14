package com.acme.customers.api.services;

import com.acme.customers.lib.v1.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * The interface Customer service. Methods to hold business logic for the Customer Application Service.
 */
public interface CustomerService {

    /**
     * Find customer by id customer.
     *
     * @param id the id
     * @return the customer
     * @throws SQLException the sql exception
     */
    Customer findCustomerById(String id) throws SQLException;

    /**
     * Find customers list.
     *
     * @param limit  the limit
     * @param offset the offset
     * @return the list
     * @throws SQLException the sql exception
     */
    List<Customer> findCustomers(Integer limit, Integer offset) throws SQLException;

    /**
     * Create customer customer.
     *
     * @param customer the customer
     * @return the customer
     * @throws SQLException the sql exception
     */
    Customer createCustomer(Customer customer) throws SQLException;

    /**
     * Update customer customer.
     *
     * @param id       the id
     * @param customer the customer
     * @return the customer
     * @throws SQLException the sql exception
     */
    Customer updateCustomer(String id, Customer customer) throws SQLException;

    /**
     * Delete customer by id.
     *
     * @param id the id
     * @throws SQLException the sql exception
     */
    void deleteCustomerById(String id) throws SQLException;
}
