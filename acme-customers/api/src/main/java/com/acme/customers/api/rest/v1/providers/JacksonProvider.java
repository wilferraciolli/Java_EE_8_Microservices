package com.acme.customers.api.rest.v1.providers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Class to provide an implementation for an Object mapper so it can be used to Serialize data on REST calls.
 * Initialises and return a mapper used to serialization of requests and responses.
 */
@Provider
public class JacksonProvider implements ContextResolver<ObjectMapper>{

    private final ObjectMapper mapper;

    public JacksonProvider(){
        //initialise and define properties for the mapper
        mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    }

    /**
     * Override get context to pass our custom mapper initialisation.
     * @param aClass
     * @return
     */
    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        return mapper;
    }
}
