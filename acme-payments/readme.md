This is a standard Spring boot application
it is configured to run on port 8000

To make it runnable, just run the `RestApplication.java` class.
inteliJ should automatically pick up acme-payment-api as the main module

##Docker Instructions
Navigate to acme-payments folder and do a `clean install`

Then build the image
	`docker build -t acme/payments .`

Then run the image
	`docker run -d -p 8000:8000 acme/payments`

Then to see the logs you can type (where the long number is the image id)
	`docker logs -f 8beb789dfb432eacc6e31c31ffdf0c3d702d8cfe98d7e59d8e462cd30d552f4a`