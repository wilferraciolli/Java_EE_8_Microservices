package com.acme.customers.api.rest.v1;

import com.acme.customers.api.rest.v1.mappers.EmptyPayloadMapper;
import com.acme.customers.api.rest.v1.mappers.ResourceNotFoundMapper;
import com.acme.customers.api.rest.v1.providers.JacksonProvider;
import com.acme.customers.api.rest.v1.resource.CustomerResource;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the main starting point for every resource within this application.
 * To run this application, run te payara-micro jar and deploy this WAR file.
 * Eg java -jar ~/dev/AppServer/payara-micro-4.1.2.174.jar --deploy api/target/acme-customers-api-1.0.0-SNAPSHOT.war
 */
@ApplicationPath("/v1")
public class RestApplication extends Application {

    /**
     * Override get class method to force Jackson to be loaded, so serializtion can be used.
     *
     * @return
     */
    @Override
    public Set<Class<?>> getClasses() {
        //get all classes from the application
        Set<Class<?>> classes = new HashSet<>();

        classes.add(JacksonJsonProvider.class);
        classes.add(JacksonProvider.class);

        //add resource class
        classes.add(CustomerResource.class);

        //Add exception mapper classes
        classes.add(EmptyPayloadMapper.class);
        classes.add(ResourceNotFoundMapper.class);
        return classes;

    }
}
