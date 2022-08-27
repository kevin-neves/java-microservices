# Microservice Shop Application, utilizing Postgres, Kafka and Docker

## Motivation
This project started during the last part of the Full-Stack developer Course, at Let's Code programming school. The main goal of the project is to create a fully integrated distributed system, utilizing some of the most used technologies available today.

## Services
* `customer-api` : responsible for CRUD operations for users.
* `products-api` : responsible for CRUD operations for products.
* `shop-cart-api` : responsible for CRUD operations when creating a **cart object**.
* `shop-validator` : receives a **cart object** and check for **user** and **products** in the respective services.
* eureka-server: used for registering the all the services in a Eureka server
* admin-server: used for registering all the services in a monitoring system server
* kafka: which is a Kafka server for messages between `shop-cart-api` and `shop-validator`. 

## Diagram
This is a visualization of the structure of the project until now.

![alt text](https://raw.githubusercontent.com/kevin-neves/java-microservices/main/ecommerceStructure.png)

## Features
* The system can be run using only one command through Docker Compose. 
* Each Java container is built using two steps:
1. The **.jar** file is compiled in a **Maven** image container.
2. Then **.jar** file is copied to a new lightweight **alpine-jre** image. The final container is about 200 MB in size.
* Each service is completely independent of others, and has it own schema on the database.
* Kafka is used for the communication between `shop-cart-api` and `shop-validator`. The docker image used don't require Zookeeper, which reduces in 700 MB the total size of the project.
* `shop-validator` uses Http requests for communicetion with other services to validate information.

## Installation and running

Even though each service could be run individually, is recommended that you use [Docker Compose](https://docs.docker.com/compose/install/) to start all services together, and in the correct order.

```
docker-compose up -d --build
```
In order to run the full project without any problems, is highly recommended that you have at least **8 GB of RAM** in your computer.

## Features to be added in the future

* There are lots of small implementations that are missing in each service.
* Integrated tests will be added soon, since they are really important for microservices.
* A gateway, with authentication and authorization, as well as a Redis cache system for storing the requests.
* Prometheus server for monitoring the services.