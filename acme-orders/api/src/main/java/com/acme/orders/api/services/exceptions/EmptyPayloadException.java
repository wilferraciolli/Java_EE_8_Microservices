package com.acme.orders.api.services.exceptions;

/**
 * The type Empty payload exception.
 */
public class EmptyPayloadException extends RuntimeException {

    private String resource;

    /**
     * Instantiates a new Empty payload exception.
     *
     * @param resource the resource
     */
    public EmptyPayloadException(String resource) {
        this.resource = resource;
    }

    /**
     * Gets resource.
     *
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * Sets resource.
     *
     * @param resource the resource
     */
    public void setResource(String resource) {
        this.resource = resource;
    }
}
