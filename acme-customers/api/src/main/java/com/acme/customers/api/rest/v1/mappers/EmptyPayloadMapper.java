package com.acme.customers.api.rest.v1.mappers;

import com.acme.customers.api.services.exceptions.EmptyPayloadException;
import com.acme.customers.lib.v1.common.ApiError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

/**
 * Provider class to handle EmptyPayloadException one it is thrown.
 * It will get the details and construct a Response with 400 bad request status.
 */
@Provider
public class EmptyPayloadMapper implements ExceptionMapper<EmptyPayloadException> {

    /**
     * Override response when EmptyPayloadException exception is thrown
     *
     * @param e
     * @return
     */
    @Override
    public Response toResponse(EmptyPayloadException e) {

        ApiError error = new ApiError();
        error.setRef(UUID.randomUUID());
        error.setStatus(400);
        error.setCode("resource.empty.payload");

        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
