package com.acme.payments.api.services.exceptions;

/**
 * The type Id mismatch exception.
 */
public class IdMismatchException extends RuntimeException {

    private String pathId;
    private String entityId;

    /**
     * Instantiates a new Id mismatch exception.
     * @param pathId the path id
     * @param entityId the entity id
     */
    public IdMismatchException(String pathId, String entityId) {
        this.pathId = pathId;
        this.entityId = entityId;
    }

    /**
     * Gets path id.
     * @return the path id
     */
    public String getPathId() {
        return pathId;
    }

    /**
     * Sets path id.
     * @param pathId the path id
     */
    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    /**
     * Gets entity id.
     * @return the entity id
     */
    public String getEntityId() {
        return entityId;
    }

    /**
     * Sets entity id.
     * @param entityId the entity id
     */
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
