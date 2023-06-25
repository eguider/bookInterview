# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)


-------------------------------------------


service rest
book management

add, edit, delete


book{
    title:String(mandatory)
    author:String(mandatory)
    sn:Number(between 1 and 9999)
}

BookController



BookService (validate book serial number and save)




BookRepository (list ou hashmap)



- <span style="color:green;font-weight:bold">Question</span> : log request response, add correlation id in the http header (uuid) and add it to all log lines
- <span style="color:red;font-weight:bold">Response</span> : Added @RequestHeader("correlation_id") in every end point in the controller, then passed the uuid to the log statement, you can test it by going to the headers section in postman, add a header with the key correlation_id and a value, then send a request (and I added a log file where spring can write the logs, it's called bookManagement.log)
- <span style="color:green;font-weight:bold">Question</span> : dockerize the jar
- <span style="color:red;font-weight:bold">Response</span> : Added the Dockerfile necessary to run the application in a dockerized environment, run gradle build to generate the jar, then run "docker build --tag=book-management:latest ." to build the image and "docker run -p8080:8080 book-management:latest" to run the container
- <span style="color:green;font-weight:bold">Question</span> : simulate cache system, like what we have done with repository, create a cache service and cache the added book for 1 min
- <span style="color:red;font-weight:bold">Response</span> : Check the BookSimulatedCacheService and how it is used when injected into the BookService
- <span style="color:green;font-weight:bold">Question</span> : redis docker and use it in local to cache teh books for 1 min
- <span style="color:red;font-weight:bold">Response</span> : Added The Spring Boot Data Redis Dependency with the necessary information in application properties and configuration in configuration/RedisConfig to connect to the local instance of redis, the local instance of redis in run using docker-compose, and it also runs a redis insight instance that works as a GUI to easily manipulate redis, as a result the getBook by id method in the controller is cached and the key used in the cache is the id, and the value is cached for 1 minute
- <span style="color:green;font-weight:bold">Question</span> : use actuator to expose prometheus metrics (stretch goal use dockerized prometheus to scrape the metrics)
- <span style="color:red;font-weight:bold">Response</span> : added the actuator and prometheus dependency in build.gradle file to expose the /metrics/prometheus end point, then created the docker-compose file to run an instance of prometheus that uses the ./prometheus/prometheus.yml file to connect to spring boot (if you want to test it change the ip address in the prometheus.yml file to your machine's ip address,go to localhost:9090 then go to status/targets, and you will find that the spring boot application target is connected and its status is UP)
- <span style="color:green;font-weight:bold">Question</span> : mysqldb docker (optional)
