# Getting Started
1. It contains the spring data/JPA, spring mvc, spring REST usage and practical example.
2. It has the implementation for sending the email notifications and generating the Piecharts(stats) by using JfreeChart.
3. To run the application, simply import the application as maven project and run as spring boot App.

### Spring MVC
1. create Location: `http://localhost:8080/locationweb/showCreate/`
2. To display Loc : `http://localhost:8080/locationweb/displayLocations`
3. Generate Report: `http://localhost:8080/locationweb/generateReport`

### REST End Points
1. Get Location: `localhost:8080/locationweb/locations`and `GET`
2. Create Location: `localhost:8080/locationweb/locations` and `POST`
   Body ````json
   {
    "id": 123,
    "name": "Srikanth",
    "code": "CA",
    "type": "URBAN"
   }
   ````
3. Update Location: same as above except Http method as `PUT`
4. Delete Location: `localhost:8080/locationweb/locations/{id}` and `DELETE`
5. Specific Retrieve: `localhost:8080/locationweb/locations/{id}` and `GET`

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

Thanks,
Krishnakanth Yachareni
Software Engineer.
yacharenikrishnakanth@gmail.com
