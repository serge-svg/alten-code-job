# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.6/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.6/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

## OpenAPI - Swagger-ui
* http://localhost:8080/swagger-ui/index.html


## API calls examples
* http://localhost:8080/api/v1/prices/
* http://localhost:8080/api/v1/prices/by?brand_id=1&product_id=35455
* http://localhost:8080/api/v1/prices/bydate?brand_id=1&product_id=35455&date=2020-06-14-10.00.00

## H2
http://localhost:8080/h2-console

* jdbc:h2:mem:prices;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
* sa

![img.png](image/h2.png)


# Alten code job assessment

In the company's e-commerce database we have the PRICES table that reflects the final price (pvp) and the rate that applies to a product from a chain between certain dates.
Below is an example of the table with the relevant fields

### PRICES TABLE
![img.png](image/img.png)

### PRICES TABLE FIEDS
* BRAND_ID: brand foreign key (1 = ZARA)
* START_DATE,  END_DATE: date ranges to apply the indicated price rate
* PRICE_LIST: Applicable price rate identifier
* PRODUCT_ID: Product code identifier
* PRIORITY: If two rates coincide in a range of dates, the one with the highest priority (greatest numerical value) is applied.
* PRICE: final price
* CURR: iso currency

### TODO
* Build an application/service in SpringBoot that provides a query rest end point such that it accepts as input parameters
    * application date, product identifier, brand identifier
* Output data
    * product identifier, brand identifier, prices rate to apply, dates of application and final price
* H2 as mem database

### TESTS
* Test 1: Request at 10:00 2020/06/14 product id 35455 brand id 1 (ZARA)
* Test 2: Request at 16:00 2020/06/14 product id 35455 brand id 1 (ZARA)
* Test 3: Request at 21:00 2020/06/14 product id 35455 brand id 1 (ZARA)
* Test 4: Request at 10:00 2020/06/15 product id 35455 brand id 1 (ZARA)
* Test 5: Request at 21:00 2020/06/16 product id 35455 brand id 1 (ZARA)

