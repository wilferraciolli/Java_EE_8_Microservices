package com.acme.customers.api.rest.v1.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Resource end point to check that the REST service is up ad running.
 */
@Path("/health")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HealthResource {

    /**
     * Gets health.
     *
     * @return the health
     */
    @GET
    public Response getHealth() {

        return Response.noContent().build();
    }
}