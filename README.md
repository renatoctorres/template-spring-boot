# Java & Spring Boot  Template - Human Resources Application

![Java](http://ForTheBadge.com/images/badges/made-with-java.svg)
![Docker](https://forthebadge.com/images/badges/docker-container.svg)

This application provides an archetype for developing Java applications with Spring Boot, using Clean Code and Clean Architecture concepts, a test suite using JUnit, Mockito and Jacoco.
APIs documented in OpenAPI3, build and libraries managed by Maven and code quality implemented by SonarLint plugin.

## Features

- CRUD APIs for Department and Employer;
- Unit Tests and Integration Tests integrated;
- Documentation API in Swagger with Open API 3;
- Clean Code and Clean Architecture;
- Build management in Maven;

## Build the image
```
mvn clean spring-boot:build-image
```

Requirements: Docker daemon on the build computer
(https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/#build-image).

## Configuration

The application configuration for local execution is found in the application.yaml and application-local.yaml files

## Running

Run the Spring Boot start command:
```
mvn spring-boot:run
```
The application exposes an APIs on port 8080 with these URLs:
http://localhost:8080

Swagger documentation is available on this endpoint:
http://localhost:8080/swagger-ui/index.html

Open API Specification is available on this endpoint:
http://localhost:8080/v3/api-docs

## Testing

Run the Maven Test command:

```
mvn test
```
After  the tests are run, the test execution report is available in the folder:

```
target\surefire-reports
```

## Stacks
<p style= "text-align: left;">
  <img src="https://skillicons.dev/icons?i=java,spring,maven,docker,git,elasticsearch" />
<img src="https://detekt.dev/img/home/detekt-logo.svg" width="48" height="48" alt="Detekt Plugin"/>
<img src="https://www.vectorlogo.zone/logos/elasticco_kibana/elasticco_kibana-icon.svg" width="48" height="48" alt="Kibana"/>
</p>