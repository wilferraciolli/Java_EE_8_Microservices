package com.acme.customers.api.rest.v1.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * The type Cors filter. This request filter will intercept REST calls and add the CORS headers
 * so the API can be called from a different localhost.
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

        //get/intercept the headers from the response
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();

        //add CORS headers to each response
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Request-Headers", "origin, content-type, accept, authorization");
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        headers.add("Access-Control-Max-Age", 12 * 60 * 60);
    }
}
