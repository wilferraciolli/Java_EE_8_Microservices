/**
 * (c) Midland Software Limited 2018
 * Name     : IntegrationHealthCheck.java
 * Author   : ferraciolliw
 * Date     : 07 Mar 2018
 */
package com.acme.orders.api.services.health;

import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.db.TimeBoundHealthCheck;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * The type Integration health check. health check for micro service.
 */
public class IntegrationHealthCheck extends HealthCheck {

    private final WebTarget webTarget;

    /**
     * Instantiates a new Integration health check.
     * @param client the client
     * @param url the url
     */
    public IntegrationHealthCheck(Client client, String url) {
        this.webTarget = client.target(url);
    }

    @Override
    protected Result check() throws Exception {
        //check whether the response was successfull
        try {
            Response response = webTarget.request().get();

            if (!response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {

                return Result.unhealthy("Received status: " + response.getStatus());
            }

            return Result.healthy();
        } catch (Exception e) {

            return Result.unhealthy(e.getMessage());
        }
    }
}
