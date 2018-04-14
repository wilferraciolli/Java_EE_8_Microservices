FROM maven:3-jdk-8

MAINTAINER tilen.faganel@me.com

RUN mkdir /app

WORKDIR /app

ADD . /app

RUN mvn clean package

EXPOSE 8000

CMD ["java", "-jar", "api/target/acme-payments-api-1.0.0-SNAPSHOT.jar"]