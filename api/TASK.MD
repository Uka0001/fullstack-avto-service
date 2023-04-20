# Test task "Car service"

## Summary
Implement the described functionality using a REST-API
server that accepts HTTP requests, stores data in a database
(DBMS - PostgreSQL) and processes them. Describe a RESTful API with Swagger.

## Essences:
### Master:
• FULL NAME
• Completed orders
### Car:
• Brand
• Model
• Year of issue • Number
• Owner
### Machine Owner: 
• Machines
• Orders
### Order:
• Car
• Description of the problem that was addressed
• Date of adoption
• Services included in the order
• Goods included in the order
• Status (accepted, in progress, completed successfully, not completed successfully,
paid)
• Total cost to customer 
• Completion date
### Service:
• Order
• Master
• Price
• Status (Paid, not paid (to master))
### Goods:
• Name 
• Cost

## Requests:
• POST - Creation of the "Master" entity
• PUT - Editing entity data
• GET - Receiving master's orders
• GET - Calculation and issuance of wages to the master
• POST - Creation of the "Car" entity
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
• POST - Creation of the entity "Goods"
• PUT - Editing entity data

## Notes:
• A person's discount on goods = the number of his orders * 1%
• A person's discount on services = the number of his orders * 2%
• Master's salary = 40% of the cost of the service he was engaged in. • When calculating and issuing a salary to a foreman, the status of the service changes to
"paid"
• When the order status changes to "successfully completed" or "not successfully
completed", the end date is equal to the current date
• Diagnostics is a service. In case of consent to the repair, this service is carried out
free of charge, if a person refuses to repair this service costs 500 UAH

## Story:
1. Sergey has a 2016 Toyota Camry. One fine day the car had a knock in the gearbox. Sergey turned to our service.
2. Sergey received an order for diagnostics.
3. He was diagnosed by master Alexei. The master found out that it was necessary to change the oil in the gearbox and that it was time to change the timing belt.
4. Sergey agreed and provided his client card, where he already had 2 orders on his account.
5. The administrator added goods and services to the order. New oil (1000 UAH), new timing belt (2500), oil change (900), timing change (1300).
6. The administrator calculated the cost of all services, taking into account the discount. They said everything would be ready in 2 days.
7. Master Aleksey took up the oil change, and master Alexander took up the replacement of the timing belt.
8. Sergey came 2 days later, paid the bill at a discount, and took his car. 9. The craftsmen were counted and given their salaries.

## Deadline
Deadline for the test task is 2-3 days Place the completed test task on GitHub