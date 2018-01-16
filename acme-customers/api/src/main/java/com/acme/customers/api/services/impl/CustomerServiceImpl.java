package com.acme.customers.api.services.impl;

import com.acme.customers.api.services.CustomerService;
import com.acme.customers.api.services.exceptions.EmptyPayloadException;
import com.acme.customers.api.services.exceptions.IdMismatchException;
import com.acme.customers.api.services.exceptions.ResourceNotFoundException;
import com.acme.customers.lib.v1.Customer;
import com.acme.customers.lib.v1.CustomerStatus;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * The type Customer service implementation.
 */
@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {

    //Do a JNDI lookup to find the data source
    @Resource(lookup = "java:global/CustomersDS")
    private DataSource dataSource;

    //create the Customer table on the database
    @PostConstruct
    private void init() {

        Connection con = null;

        try {
            con = dataSource.getConnection();

            PreparedStatement stmt = con.prepareStatement("CREATE TABLE customers(" +
                    "id varchar(36) primary key, first_name varchar(255), last_name varchar(255), " +
                    "email varchar(255), status varchar(255), date_of_birth TIMESTAMP, " +
                    "updated_at TIMESTAMP, created_at TIMESTAMP)");

            stmt.executeUpdate();


        } catch (SQLException e) {

            throw new RuntimeException(e);
        } finally {

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ignored) {
            }
        }
    }

    @Override
    public Customer findCustomerById(String id) throws SQLException {

        Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM customers WHERE id = ? ORDER BY id");
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {

            throw new ResourceNotFoundException(Customer.class.getSimpleName(), id);
        }

        Customer customer = new Customer();
        customer.setId(rs.getString("id"));
        customer.setUpdatedAt(rs.getDate("updated_at"));
        customer.setCreatedAt(rs.getDate("created_at"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setEmail(rs.getString("email"));
        customer.setDateOfBirth(rs.getDate("date_of_birth"));
        customer.setStatus(CustomerStatus.valueOf(rs.getString("status")));

        con.close();

        return customer;
    }

    @Override
    public List<Customer> findCustomers(Integer limit, Integer offset) throws SQLException {

        List<Customer> customers = new ArrayList<>();

        String query = "SELECT * FROM customers ORDER BY id";

        if (limit != null && limit > 0) {

            query += " LIMIT " + limit;
        }

        if (offset != null && offset > 0) {

            query += " OFFSET " + offset;
        }

        Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Customer customer = new Customer();
            customer.setId(rs.getString("id"));
            customer.setUpdatedAt(rs.getDate("updated_at"));
            customer.setCreatedAt(rs.getDate("created_at"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setEmail(rs.getString("email"));
            customer.setDateOfBirth(rs.getTimestamp("date_of_birth"));
            customer.setStatus(CustomerStatus.valueOf(rs.getString("status")));

            customers.add(customer);
        }

        con.close();

        return customers;
    }

    @Override
    public Customer createCustomer(Customer customer) throws SQLException {

        //check if the value passed in is not nul
        if (customer == null) {
            throw new EmptyPayloadException(Customer.class.getSimpleName());
        }
        Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("INSERT INTO customers " +
                "(id, first_name, last_name, email, date_of_birth, status, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

        String id = UUID.randomUUID().toString();

        stmt.setString(1, id);
        stmt.setString(2, customer.getFirstName());
        stmt.setString(3, customer.getLastName());
        stmt.setString(4, customer.getEmail());

        if (customer.getDateOfBirth() != null) {
            stmt.setTimestamp(5, new Timestamp(customer.getDateOfBirth().getTime()));
        } else {
            stmt.setTimestamp(5, new Timestamp(new Date().getTime()));
        }

        if (customer.getStatus() != null) {
            stmt.setString(6, customer.getStatus().toString());
        }

        Timestamp timestampNow = new Timestamp(new Date().getTime());

        stmt.setTimestamp(7, timestampNow);
        stmt.setTimestamp(8, timestampNow);

        stmt.executeUpdate();

        customer.setId(id);
        customer.setUpdatedAt(timestampNow);
        customer.setCreatedAt(timestampNow);

        con.close();

        return customer;
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) throws SQLException {

        if (customer == null) {
            throw new EmptyPayloadException(Customer.class.getSimpleName());
        }

        if (!id.equals(customer.getId())) {
            throw new IdMismatchException(id, customer.getId());
        }

        Connection con = dataSource.getConnection();

        PreparedStatement stmt = con.prepareStatement("SELECT * FROM customers WHERE id = ? ORDER BY id");
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {

            throw new ResourceNotFoundException(Customer.class.getSimpleName(), id);
        }

        Timestamp createdAt = rs.getTimestamp("created_at");

        stmt = con.prepareStatement("UPDATE customers SET " +
                "id = ?, first_name = ?, last_name = ?, email = ?, date_of_birth = ?, status = ?, updated_at = ? " +
                "WHERE id = ?");

        stmt.setString(1, id);
        stmt.setString(2, customer.getFirstName());
        stmt.setString(3, customer.getLastName());
        stmt.setString(4, customer.getEmail());

        if (customer.getDateOfBirth() != null) {

            stmt.setTimestamp(5, new Timestamp(customer.getDateOfBirth().getTime()));
        } else {
            stmt.setTimestamp(5, new Timestamp(new Date().getTime()));
        }


        if (customer.getStatus() != null) {
            stmt.setString(6, customer.getStatus().toString());
        }

        Timestamp timestampNow = new Timestamp(new Date().getTime());

        stmt.setTimestamp(7, timestampNow);
        stmt.setString(8, id);

        stmt.executeUpdate();

        customer.setCreatedAt(createdAt);
        customer.setUpdatedAt(timestampNow);

        con.close();

        return customer;
    }

    @Override
    public void deleteCustomerById(String id) throws SQLException {

        Connection con = dataSource.getConnection();

        PreparedStatement stmt = con.prepareStatement("SELECT * FROM customers WHERE id = ? ORDER BY id");
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {

            throw new ResourceNotFoundException(Customer.class.getSimpleName(), id);
        }

        stmt = con.prepareStatement("DELETE FROM customers WHERE id = ?");
        stmt.setString(1, id);

        stmt.executeUpdate();

        con.close();
    }
}
