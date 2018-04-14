To run this micro service do the following:
Navigate to the project directory 
	`cd C:\DEV\GIT\Java_Microservices\acme-customers>`

Perform a clean package	
	`mvn clean package`

Then tell java to use the payara micro jar to run this application
	`java -jar "C:\DEV\Servers\payara-micro-4.1.2.174.jar" --deploy api/target/acme-customers-api-1.0.0-SNAPSHOT.war`

The you can access this service on
	`http://localhost:8080/acme-customers-api-1.0.0-SNAPSHOT/v1/customers GET`
	
##For docker instructions
 First do a clean install so the war file will be available
 Second build the image with the following command (Ps you need to be acme-customers folder)
 	`docker build -t acme/customers .` (Ps you might need to log in first with `docker login`)
 
 Then you can run the image as follow
 	`docker run -d -p 8080:8080 acme/customers`
 
 Then if you want to see the logs for payara type the following (where the long id is the container image id)
 	`docker logs -f e0f7ed6f251a79cb7286ea6948e4f20838369081dd2688ce028556cbea06f731`
 	
 Now head on to Post mand and test the endpoint
 `http://localhost:8080/acme-customers-api-1.0.0-SNAPSHOT/v1/customers`