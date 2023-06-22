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



- log request response, add correlation id in the http header (uuid) and add it to all log lines
- dockerize the jar
- simulate cache system, like what we have done with repository, create a cache service and cache the added book for 1 min
- redis docker and use it in local to cache teh books for 1 min
- use actuator to expose prometheus metrics (strech goal use dockerized prometheus to scrape the metrics)
- mysqldb docker (optional)
