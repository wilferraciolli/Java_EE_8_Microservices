package com.acme.customers.api.mappers;

import com.acme.customers.api.models.db.CustomerEntity;
import com.acme.customers.lib.v1.Customer;

/**
 * Utility class to map database to java objects.
 */
public class CustomerMapper {

    /**
     * To customer customer.
     *
     * @param entity the entity
     * @return the customer
     */
    public static Customer toCustomer(CustomerEntity entity) {

        if (entity == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setId(entity.getId());
        customer.setCreatedAt(entity.getCreatedAt());
        customer.setUpdatedAt(entity.getUpdatedAt());
        customer.setFirstName(entity.getFirstName());
        customer.setLastName(entity.getLastName());
        customer.setStatus(entity.getStatus());
        customer.setDateOfBirth(entity.getDateOfBirth());

        return customer;
    }

    /**
     * To customer entity customer entity.
     *
     * @param customer the customer
     * @return the customer entity
     */
    public static CustomerEntity toCustomerEntity(Customer customer) {

        if (customer == null) {
            return null;
        }

        CustomerEntity entity = new CustomerEntity();
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setStatus(customer.getStatus());
        entity.setDateOfBirth(customer.getDateOfBirth());

        return entity;
    }
}
