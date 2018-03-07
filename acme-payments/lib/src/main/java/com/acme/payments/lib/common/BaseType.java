package com.acme.payments.lib.common;

import java.util.Date;

/**
 * The type Base type.
 */
public class BaseType {

    private String id;
    private Date createdAt;
    private Date updatedAt;

    /**
     * Gets id.
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets created at.
     * @return the created at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     * @param createdAt the created at
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updated at.
     * @return the updated at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updated at.
     * @param updatedAt the updated at
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
