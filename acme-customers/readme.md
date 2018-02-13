To run this micro service do the following:
Navigate to the project directory 
	`cd C:\DEV\GIT\Java_Microservices\acme-customers>`

Perform a clean package	
	`mvn clean package`

Then tell java to use the payara micro jar to run this application
	`java -jar "C:\DEV\Servers\payara-micro-4.1.2.174.jar" --deploy api/target/acme-customers-api-1.0.0-SNAPSHOT.war`

The you can access this service on
	`http://localhost:8080/acme-customers-api-1.0.0-SNAPSHOT/v1/customers GET`