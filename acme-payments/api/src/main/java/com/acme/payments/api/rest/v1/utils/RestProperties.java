package com.acme.payments.api.rest.v1.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

/**
 * The type Rest properties.
 */
@Component
public class RestProperties {

    /**
     * Jackson builder jackson 2 object mapper builder.
     * @return the jackson 2 object mapper builder
     */
    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {

        Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();

        b.indentOutput(true).serializationInclusion(JsonInclude.Include.NON_NULL);
        b.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        b.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        b.featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return b;
    }
}
