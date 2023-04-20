# :blue_car:  Car service app :pickup_truck:

## :notebook_with_decorative_cover: Summary:
REST-API
Server app that accepts HTTP requests, stores data in a database
(DBMS - PostgreSQL) and processes them, perform CRUD operations
and implement REST API. Implement Swagger and SpringDoc.

## :hammer: Used technologies:
- Java17
- Spring Boot 3.0.5
- PostgreSQL
- Swagger UI
- SpringDoc
- REST API
- Checkstyle

## :bookmark_tabs: Functionality:
• POST - Creation of the "Master" entity
• PUT - Editing entity data
• GET - Receiving master's orders
• GET - Calculation and issuance of wages to the master
• POST - Creation of the "Machine" entity
• PUT - Editing entity data
• POST - Creation of the entity "Owner of the Machine" • PUT - Editing the data of the entity
• GET - Get this customer's orders
• POST - Creation of the "Order" entity
• POST - Adding "Product" to the "Order" entity • PUT - Editing entity data
• PUT - Editing the status of the "Order"
• GET - Calculation of the cost of the "Order"
• POST - Creation of the "Service" entity
• PUT - Editing entity data • PUT - Editing the "Service" status
• POST - Creation of the entity "Product"
• PUT - Editing entity data

## :desktop_computer: Project SetUp:
1. Clone this repo.
2. Start your PostgreSQLServer
3. Create DB from int_db.sql script in resources.
4. Fill your data(login, password, url, driver) 
in src/main/resources/application.properties file.
5. Start app from:
src/main/java/com/example/autoservice/AutoServiceApplication.java file.
6. Enjoy the app.

## :computer: Entering Swagger UI throw SpringDoc:
1. Start app as in previous chapter.
2. Enter http://localhost:8080/swagger-ui/index.html#/ 
and you`ll see all the needed Swagger UI functional and REST endpoints ;)