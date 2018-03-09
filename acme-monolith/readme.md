To run this application, build the EAR file and deploy onto an app server.

The App server has to be on port 9080 as the other services will call it there.
So it will be accessed in `http://localhost:9080/`

Add the data source on the app server WildFly/standalone/configuration/standalone.xml
```
	<datasource jndi-name="java:jboss/datasources/AcmeDS" pool-name="AcmeDS" enabled="true" use-java-context="true">
                    <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
                    <driver>h2</driver>
                    <security>
                        <user-name>sa</user-name>
                        <password>sa</password>
                    </security>
                </datasource>
```

start WildFLy on port 9080 so the service can be found at `http://localhost:9080/acme-monolith-soap/ECommerceWs?wsdl`

Eg `L:\DEV\AppServer\wildfly-11.0.0.Final\bin> .\standalone.bat -Djboss.socket.binding.port-offset=1000`


See wildFLySetUp png image for s a screenshot



