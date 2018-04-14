/**
 * (c) Midland Software Limited 2018
 * Name     : OrderResourceTest.java
 * Author   : ferraciolliw
 * Date     : 02 Mar 2018
 */
package com.acme.orders.api.tests;

import com.acme.orders.api.rest.v1.RestApplication;
import com.acme.orders.api.rest.v1.RestConfiguration;
import com.acme.orders.api.rest.v1.providers.JacksonProvider;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * The type Order resource test.
 * This class initializes the micro service so it can be called via HTTP to test.
 * Note that it needs a config.yaml file to configure the server.
 */
@Ignore
public class OrderResourceTest {

    /**
     * The constant RULE. It allows to pass the application class with the server config so it spins a server for the test
     */
    @ClassRule
    public static final DropwizardAppRule<RestConfiguration> RULE =
            new DropwizardAppRule<>(RestApplication.class,
                    ResourceHelpers.resourceFilePath("config.yml"));

    /**
     * Test find orders. This test will make a call to the microservice that dropwizard has started as part of the test.
     */
    @Test
    public void testFindOrders() {

        Client client = ClientBuilder.newClient().register(JacksonProvider.class);

        Response response = client.target(
                String.format("http://localhost:%d/orders", RULE.getLocalPort()))
                .request()
                .get();

        assertThat(response.getStatus()).isEqualTo(200);
    }
}
