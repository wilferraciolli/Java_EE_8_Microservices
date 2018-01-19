package com.acme.orders.api.rest.v1.mappers;

import com.acme.orders.lib.v1.common.ApiError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

/**
 * The type General mapper. Exception mapper. Returns 500 error code.
 */
@Provider
public class GeneralMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {

        ApiError error = new ApiError();
        error.setRef(UUID.randomUUID());
        error.setStatus(500);
        error.setCode("internal.error");

        exception.printStackTrace();

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
}
