package com.acme.customers.api.services;

/**
 * The type Resource not found exception. Represents 404.
 */
public class ResourceNotFoundException extends RuntimeException {

    private String resource;
    private String identifier;

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param resource   the resource
     * @param identifier the identifier
     */
    public ResourceNotFoundException(String resource, String identifier) {
        this.resource = resource;
        this.identifier = identifier;
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

    /**
     * Gets identifier.
     *
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets identifier.
     *
     * @param identifier the identifier
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
