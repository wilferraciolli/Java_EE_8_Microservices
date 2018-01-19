package com.acme.orders.api.rest.v1.mappers;

import com.acme.orders.api.services.exceptions.IdMismatchException;
import com.acme.orders.lib.v1.common.ApiError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

/**
 * The type Id mismatch mapper. Exception mapper. Returns 400 bad request.
 */
@Provider
public class IdMismatchMapper implements ExceptionMapper<IdMismatchException> {

    @Override
    public Response toResponse(IdMismatchException exception) {

        ApiError error = new ApiError();
        error.setRef(UUID.randomUUID());
        error.setStatus(400);
        error.setCode("resource.id.mismatch");

        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
