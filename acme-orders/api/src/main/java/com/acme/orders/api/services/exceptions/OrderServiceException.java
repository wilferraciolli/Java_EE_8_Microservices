package com.acme.orders.api.services.exceptions;

import com.acme.orders.lib.v1.common.OrderServiceErrorCode;

/**
 * The type Order service exception.
 */
public class OrderServiceException extends RuntimeException {

    private OrderServiceErrorCode code;

    /**
     * Instantiates a new Order service exception.
     *
     * @param code the code
     */
    public OrderServiceException(OrderServiceErrorCode code) {
        this.code = code;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public OrderServiceErrorCode getCode() {
        return code;
    }
}
