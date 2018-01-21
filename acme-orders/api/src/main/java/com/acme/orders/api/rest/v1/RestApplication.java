package com.acme.orders.api.rest.v1;

import com.acme.orders.api.models.OrderDAO;
import com.acme.orders.api.models.db.OrderEntity;
import com.acme.orders.api.models.db.OrderItemEntity;
import com.acme.orders.api.rest.v1.mappers.*;
import com.acme.orders.api.rest.v1.resources.OrderResource;
import com.acme.orders.api.services.OrderService;
import com.acme.orders.api.services.impl.OrderServiceImpl;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * The type Rest application. Main application class to extends the configuration class.
 */
public class RestApplication extends Application<RestConfiguration> {

    /**
     * Main.
     *
     * @param args the args
     * @throws Exception the exception
     */
    public static void main(String args[]) throws Exception {
        //call run to instantiate a new service
        new RestApplication().run(args);
    }

    //Add hibernate bundle to use h2 in-memory database
    private final HibernateBundle<RestConfiguration> hibernate = new HibernateBundle<RestConfiguration>(OrderEntity.class, OrderItemEntity.class) {

        @Override
        public DataSourceFactory getDataSourceFactory(RestConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<RestConfiguration> bootstrap) {

        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(RestConfiguration configuration, Environment environment) throws Exception {

        //configure DropWizard internal Jackson
        environment.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        environment.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        environment.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        environment.getObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        environment.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //instantiate dependencies
        OrderService orderService = new OrderServiceImpl(
                new OrderDAO(hibernate.getSessionFactory(), environment.metrics()),
                environment.metrics()
        );

        //configure Jersey and add all required classes to it
        environment.jersey().register(new OrderResource(orderService));

        environment.jersey().register(EmptyPayloadMapper.class);
        environment.jersey().register(GeneralMapper.class);
        environment.jersey().register(IdMismatchMapper.class);
        environment.jersey().register(ResourceNotFoundMapper.class);
        environment.jersey().register(OrderServiceMapper.class);

    }

    /**
     * Gets auth algorithm.
     *
     * @param publicKey the public key
     * @return the auth algorithm
     * @throws NoSuchAlgorithmException the no such algorithm exception
     * @throws InvalidKeySpecException  the invalid key spec exception
     */
    private Algorithm getAuthAlgorithm(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {

        KeyFactory kf = KeyFactory.getInstance("RSA");

        X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));

        RSAPublicKey pubKey = (RSAPublicKey) kf.generatePublic(keySpecX509);

        return Algorithm.RSA256(pubKey, null);
    }
}
