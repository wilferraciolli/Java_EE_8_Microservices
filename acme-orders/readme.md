To run this drop wizard application you need to create a new 'Application' run from the Edit configurations tab.

    For Main class = choose the Rest Service Resource
    For server arguments = server config.yml
    Tick Single instance
   
Ps this micro service can only work if the dependan2zt microservices have already started prior to itself

##Docker how to
First navigate to acme-orders folder and do a `mvn clean oinstall`
Note that because this microservice needs to integrate with the other microservices, we will use the 
`docker-compose` script to spin up and manage every container

The build the image
	`docker build -t acme/orders .`
	
Then to run the application, run the docker compose, so every microservice will start up
