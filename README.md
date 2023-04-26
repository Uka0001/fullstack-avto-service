# :pickup_truck: FullStack auto-service app

📔 Summary:

Fullstack app with Angular on client side and server side on Java17 with Spring Boot REST-API that accepts HTTP requests, stores data in a database (DBMS - PostgreSQL) and processes them, perform CRUD operations and implement REST API. Implement Swagger and SpringDoc, Docker.

🔨 Used technologies:

Back end:
Java17
Spring Boot 3.0.5
Swagger UI
SpringDoc
REST API
Checkstyle
Docker

Front end:
Angular

BD:
PostgreSQL

📑 Functionality:

• POST - Creation of the "Master" entity
• PUT - Editing entity data
• GET - Receiving master's orders
• GET - Calculation and issuance of wages to the master
• POST - Creation of the "Machine" entity
• PUT - Editing entity data
• POST - Creation of the entity "Owner of the Machine"
• PUT - Editing the data of the entity
• GET - Get this customer's orders
• POST - Creation of the "Order" entity
• POST - Adding "Product" to the "Order" entity
• PUT - Editing entity data
• PUT - Editing the status of the "Order"
• GET - Calculation of the cost of the "Order"
• POST - Creation of the "Service" entity
• PUT - Editing entity data
• PUT - Editing the "Service" status
• POST - Creation of the entity "Product"
• PUT - Editing entity data

🖥️ BackEnd Project SetUp:

Clone this repo.
Start your PostgreSQLServer
Create DB from int_db.sql script in resources.
Fill your data(login, password, url, driver) in src/main/resources/application.properties file.
Start app from: src/main/java/com/example/autoservice/AutoServiceApplication.java file.
Enjoy the app.
💻 Entering Swagger UI throw SpringDoc:

Start app as in previous chapter.
Enter http://localhost:8080/swagger-ui/index.html#/ and you`ll see all the needed Swagger UI functional and REST endpoints ;)

:blue_car::car:
:book:
:hammer_and_pick:
