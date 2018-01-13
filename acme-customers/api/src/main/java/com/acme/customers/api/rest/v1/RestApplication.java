package com.acme.customers.api.rest.v1;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * This is the main starting point for every resource within this application.
 * To run this application, run te payara-micro jar and deploy this WAR file.
 * Eg java -jar ~/dev/AppServer/payara-micro-4.1.2.174.jar --deploy api/target/acme-customers-api-1.0.0-SNAPSHOT.war
 */
@ApplicationPath("/v1")
public class RestApplication extends Application {
}
