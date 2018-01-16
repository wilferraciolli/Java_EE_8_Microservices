package com.acme.customers.api.services.impl;

import com.acme.customers.api.mappers.CustomerMapper;
import com.acme.customers.api.models.db.CustomerEntity;
import com.acme.customers.api.services.CustomerService;
import com.acme.customers.api.services.exceptions.EmptyPayloadException;
import com.acme.customers.api.services.exceptions.IdMismatchException;
import com.acme.customers.api.services.exceptions.ResourceNotFoundException;
import com.acme.customers.lib.v1.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Customer service implementation. This is the stateless bean to manage customer details.
 */
@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer findCustomerById(String id) throws SQLException {

        CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, id);

        if (Objects.isNull(customerEntity)) {
            throw new ResourceNotFoundException(Customer.class.getSimpleName(), id);
        }

        return CustomerMapper.toCustomer(customerEntity);
    }

    @Override
    public List<Customer> findCustomers(Integer limit, Integer offset) throws SQLException {

        TypedQuery<CustomerEntity> query = entityManager.createNamedQuery("CustomerEntity.findAll", CustomerEntity.class);

        //set pagination params
        if (limit != null && limit > 0) {
            query = query.setMaxResults(limit);
        }
        if (offset != null && offset > 0) {
            query = query.setFirstResult(offset);
        }

        //return list of customers
        List<CustomerEntity> customerEntities = query.getResultList();
        return customerEntities.stream()
                .map(CustomerMapper::toCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public Customer createCustomer(Customer customer) throws SQLException {
        if (Objects.isNull(customer)) {
            throw new EmptyPayloadException(Customer.class.getSimpleName());
        }

        //get the customer given by the API
        CustomerEntity customerEntity = CustomerMapper.toCustomerEntity(customer);
        //clear the id
        customerEntity.setId(null);

        entityManager.persist(customer);

        return CustomerMapper.toCustomer(customerEntity);
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) throws SQLException {

        if (Objects.isNull(customer)) {
            throw new EmptyPayloadException(Customer.class.getSimpleName());
        }

        //check that the id match the object passed in with the URL
        if (!id.equals(customer.getId())) {
            throw new IdMismatchException(id, customer.getId());
        }

        //load the current customer for the id
        CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, id);
        if (customerEntity == null) {
            throw new ResourceNotFoundException(Customer.class.getSimpleName(), id);
        }

        //build the customer with the details to be updated
        CustomerEntity updatedCustomerEntity = CustomerMapper.toCustomerEntity(customer);

        updatedCustomerEntity.setId(id);
        updatedCustomerEntity.setCreatedAt(customerEntity.getCreatedAt());

        //persist the update
        updatedCustomerEntity = entityManager.merge(updatedCustomerEntity);

        return CustomerMapper.toCustomer(updatedCustomerEntity);

    }

    @Override
    public void deleteCustomerById(String id) throws SQLException {

        CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, id);

        if (Objects.isNull(customerEntity)) {
            throw new ResourceNotFoundException(Customer.class.getSimpleName(), id);
        }

        entityManager.remove(customerEntity);
    }
}
