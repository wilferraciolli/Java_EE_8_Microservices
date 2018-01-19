package com.acme.orders.api.rest.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * The type Rest configuration. DropWizard Configuration class.
 * Eg external URLs
 */
public class RestConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    @NotNull
    private String customersUrl;

    @NotNull
    private String catalogueUrl;

    @NotNull
    private String authPublicKey;

    /**
     * Gets data source factory.
     *
     * @return the data source factory
     */
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    /**
     * Gets database.
     *
     * @return the database
     */
    public DataSourceFactory getDatabase() {
        return database;
    }

    /**
     * Gets customers url.
     *
     * @return the customers url
     */
    public String getCustomersUrl() {
        return customersUrl;
    }

    /**
     * Gets catalogue url.
     *
     * @return the catalogue url
     */
    public String getCatalogueUrl() {
        return catalogueUrl;
    }

    /**
     * Gets auth public key.
     *
     * @return the auth public key
     */
    public String getAuthPublicKey() {
        return authPublicKey;
    }
}