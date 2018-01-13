package com.acme.customers.api.rest.v1.resource;

import com.acme.customers.lib.v1.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The type Customer resource. Application single instance bean.
 */
@Path("/customers")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @GET
    public Response getCustomers(@QueryParam("limit") Integer limit, @QueryParam("offset") Integer offset ){

    }

    @POST
    public Response createCustomer(Customer newCustomer){

    }

    @GET
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") String id){

    }
}
