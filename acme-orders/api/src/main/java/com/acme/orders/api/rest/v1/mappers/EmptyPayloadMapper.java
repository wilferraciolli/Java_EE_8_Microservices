package com.acme.orders.api.rest.v1.mappers;

import com.acme.orders.api.services.exceptions.EmptyPayloadException;
import com.acme.orders.lib.v1.common.ApiError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;


/**
 * The type Empty payload mapper. Exception mapper. Returns 400 bad request.
 */
@Provider
public class EmptyPayloadMapper implements ExceptionMapper<EmptyPayloadException> {

    @Override
    public Response toResponse(EmptyPayloadException exception) {

        ApiError error = new ApiError();
        error.setRef(UUID.randomUUID());
        error.setStatus(400);
        error.setCode("resource.empty.payload");

        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
