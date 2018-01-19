package com.acme.orders.api.rest.v1.mappers;

import com.acme.orders.api.services.exceptions.OrderServiceException;
import com.acme.orders.lib.v1.common.ApiError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

/**
 * The type Order service mapper. Exception mapper. Returns a 400 error response.
 */
@Provider
public class OrderServiceMapper implements ExceptionMapper<OrderServiceException> {

    @Override
    public Response toResponse(OrderServiceException exception) {

        ApiError apiError = new ApiError();
        apiError.setRef(UUID.randomUUID());
        apiError.setStatus(400);
        apiError.setCode(exception.getCode().getCode());

        return Response.status(Response.Status.BAD_REQUEST).entity(apiError).build();
    }
}
