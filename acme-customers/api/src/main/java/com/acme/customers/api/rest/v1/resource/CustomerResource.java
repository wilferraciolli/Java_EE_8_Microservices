package com.acme.customers.api.rest.v1.resource;

import com.acme.customers.api.services.CustomerService;
import com.acme.customers.lib.v1.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * The type Customer resource. Application single instance bean.
 */
@Path("/customers")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    private CustomerService customerService;

    /**
     * Gets customers.
     *
     * @param limit  the limit
     * @param offset the offset
     * @return the customers
     * @throws SQLException the sql exception
     */
    @GET
    public Response getCustomers(@QueryParam("limit") Integer limit,
                                 @QueryParam("offset") Integer offset) throws SQLException {

        return Response.ok(customerService.findCustomers(limit, offset)).header("X-Total-Count", 0).build();
    }

    /**
     * Gets customer.
     *
     * @param id the id
     * @return the customer
     * @throws SQLException the sql exception
     */
    @GET
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") String id) throws SQLException {

        return Response.ok(customerService.findCustomerById(id)).build();
    }

    /**
     * Create customer response.
     *
     * @param newCustomer the new customer
     * @return the response
     * @throws SQLException the sql exception
     */
    @POST
    public Response createCustomer(@Valid Customer newCustomer) throws SQLException {

        return Response.ok(customerService.createCustomer(newCustomer)).build();
    }

    /**
     * Update customer response.
     *
     * @param id              the id
     * @param updatedCustomer the updated customer
     * @return the response
     * @throws SQLException the sql exception
     */
    @PUT
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") String id, Customer updatedCustomer) throws SQLException {

        return Response.ok(customerService.updateCustomer(id, updatedCustomer)).build();
    }

    /**
     * Delete customer response.
     *
     * @param id the id
     * @return the response
     * @throws SQLException the sql exception
     */
    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") String id) throws SQLException {
        customerService.deleteCustomerById(id);

        return Response.noContent().build();
    }
}
