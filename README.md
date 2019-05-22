# spring-boot-microservices-sample
Spring Boot Microservices Sample

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Maven 3](https://maven.apache.org)

## Build

For build use the command:

```shell
mvn clean install
```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `org.shelden.ss.uaa.UaaApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
cd ss-uaa
mvn spring-boot:run
```

Alternatively you can build it and run with docker compose like so:

```shell
mvn clean install
docker-compose -f docker-compose.yml up --build
```

## Copyright

See [LICENSE](LICENSE)