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

    /**
     * Gets data source factory.
     *
     * @return the data source factory
     */
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

}
