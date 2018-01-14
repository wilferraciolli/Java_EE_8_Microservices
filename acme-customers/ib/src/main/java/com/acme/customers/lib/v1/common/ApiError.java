package com.acme.customers.lib.v1.common;

import java.util.UUID;

/**
 * The type Api error. Core classes to be reused by multiple micro services.
 */
public class ApiError {

    private UUID ref;
    private Integer status;
    private String code;

    /**
     * Gets ref.
     *
     * @return the ref
     */
    public UUID getRef() {
        return ref;
    }

    /**
     * Sets ref.
     *
     * @param ref the ref
     */
    public void setRef(UUID ref) {
        this.ref = ref;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }
}
