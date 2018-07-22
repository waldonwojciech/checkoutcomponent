# Checkout component 3.0

Market checkout component module

## Technologies stack

* Spring
* Hibernate
* Maven
* Lombok
* Java 8
* JUnit
* TestNG
* AssertJ
* Mockito

## Modules
Application has been divided into three parts:

* api
* application
* domain

### Api module ###
Module resposible for exposing complete application rest api.

### Application module ###
Module resposible for application deployment process.

### Domain module ###
Module resposible for providing database structure.

### Installing

>clean install -Pdev -f pom.xml

Install process takes into account maven profile:
 >-p
 
 Actually there is available only dev profile.

## Deployment
Recommended deploy command:
>clean install -Pdev spring-boot:run -f pom.xml

Working directory:
>checkoutcomponent/checkoutcomponent/application

Through maven profile spring specify it's own - if there is no value consider default.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

 [Git](https://git-scm.com/) has been used as basic versioning tool.

## Author

* **Wojciech Waldon**