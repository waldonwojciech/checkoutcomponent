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

* **CartController** expose rest endpoints. 
Every exception is catched, logged and throwed with proper message.

### Application module ###
Module resposible for application deployment process.

* **CheckoutComponentApplication** is the main application runnable class.

#### Properties
**application.properties** provide configuration for specified spring profile.

#### Initial storage state
Initial storage state is provided through **data.sql** file.

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


## Testing

* unit tests - **DiscountServiceTest** contains discount calculation logic unit test 
* integration tests - integration tests have been used to check correctness database schema 
* acceptance tests - **CartControllerAT** contains module main functionalities acceptance tests

## Buiding

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

 [Git](https://git-scm.com/) has been used as basic versioning tool.

## Author

* **Wojciech Waldon**