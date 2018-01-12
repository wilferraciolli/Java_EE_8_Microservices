package com.acme.customers.api.rest.v1.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The type Customer resource.
 */
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    /**
     * Hello response.
     *
     * @return the response
     */
    @GET
    public Response hello(){
        return Response.ok("Hello").build();
    }
}
