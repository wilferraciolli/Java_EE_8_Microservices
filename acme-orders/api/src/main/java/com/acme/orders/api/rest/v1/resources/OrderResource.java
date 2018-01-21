package com.acme.orders.api.rest.v1.resources;

import com.acme.orders.api.services.OrderService;
import com.acme.orders.lib.v1.Order;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Order resource. Order resource.
 */
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    private OrderService orderService;

    /**
     * Instantiates a new Order resource and inject dependencies.
     *
     * @param orderService the order service
     */
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Gets order.
     *
     * @param limit  the limit
     * @param offset the offset
     * @return the order
     */
    @GET
    @UnitOfWork
    @Timed
    public Response getOrder(@QueryParam("limit") Integer limit,
                             @QueryParam("offset") Integer offset) {

        List<Order> customers = orderService.findOrders(limit, offset);
        Long customersCount = orderService.findOrdersCount();

        return Response.ok(customers).header("X-Total-Count", customersCount).build();
    }

    /**
     * Gets order.
     *
     * @param id the id
     * @return the order
     */
    @GET
    @Path("/{id}")
    @UnitOfWork
    @Timed
    public Response getOrder(@PathParam("id") String id) {

        Order order = orderService.findOrderById(id);

        return Response.ok(order).build();
    }

    /**
     * Create order response.
     *
     * @param newOrder the new order
     * @return the response
     */
    @POST
    @UnitOfWork
    @Timed
    public Response createOrder(Order newOrder) {

        Order order = orderService.createOrder(newOrder);

        return Response.ok(order).build();
    }

    /**
     * Complete order response.
     *
     * @param id the id
     * @return the response
     */
    @POST
    @Path("/{id}/complete")
    @UnitOfWork
    @Timed
    public Response completeOrder(@PathParam("id") String id) {

        Order order = orderService.completeOrder(id);

        return Response.ok(order).build();
    }

    /**
     * Cancel order response.
     *
     * @param id the id
     * @return the response
     */
    @POST
    @Path("/{id}/cancel")
    @UnitOfWork
    @Timed
    public Response cancelOrder(@PathParam("id") String id) {

        Order order = orderService.cancelOrder(id);

        return Response.ok(order).build();
    }
}
