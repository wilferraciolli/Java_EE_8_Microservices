package com.acme.customers.api.rest.v1.filters;

import com.acme.customers.lib.v1.common.ApiError;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.UUID;

/**
 * The type Auth filter. This filter will intercept any REST calls and run the filter method.
 * This is specifically used for Authorization.
 * If more ContainerRequestFilter are created, then it can be configured to use a sequence of executions in order.
 */
@Provider
public class AuthFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // check whether the Autorization header is on the request
        String authHeader = requestContext.getHeaderString("Authorization");

        if (StringUtils.isBlank(authHeader)) {
            ApiError error = new ApiError();
            error.setRef(UUID.randomUUID());
            error.setStatus(401);
            error.setCode("unauthorized");

            //abort REST call and send the unauthorised response.
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(error).build());
        }
    }
}
