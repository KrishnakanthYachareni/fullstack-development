# Getting Started
### Application REST End Points:
1. Fetch All Patients: `http://localhost:8080/clinicalservices/api/patients/`  || `GET`
2. Fetch Specific Patient: `http://localhost:8080/clinicalservices/api/patients/{id}` || `GET`
3. Create Patient: `http://localhost:8080/clinicalservices/api/patients/` || `POST`
   
   RequestBody:
   ````json
	{
    "lastName": "Yachareni",
    "firstName": "Krishnakanth",
    "age": 24
	}
	````   
4. Update Clinical Data: `http://localhost:8080/clinicalservices/api/clinicals/` || `POST`
   
   RequestBody:
   ````json
   {
    "componentName": "hw",
    "componentValue": "6/180",
    "patientId": 1
   }
   ````
5. Calculate & Fetch Patient BMI: `http://localhost:8080/clinicalservices/api/patients/analyze/1` || `GET`
6. Fetch Clinical Data: `http://localhost:8080/clinicalservices/api/clinicals/{patientId}/{componentName}` || `GET`

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

