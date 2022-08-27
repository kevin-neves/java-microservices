# Microservice Shop Application, utilizing Postgres, Kafka and Docker

## Motivation
This project started during the last part of the Full-Stack developer Course, at Let's Code programming school. The main goal of the project is to create a fully integrated distributed system, utilizing some of the most used technologies available today.

## Services
* `customer-api`: responsible for CRUD operations for users. `port: 8083`
* `products-api`: responsible for CRUD operations for products.  `port: 8082`
* `shop-cart-api`: responsible for CRUD operations when creating a **cart object**. `port: 8081`
* `shop-validator`: receives a **cart object** and check for **user** and **products** in the respective services. `port: 8084`
* `postgres`: Postgres database for services above.  `port: 5432`
* `eureka-server`: used for registering the all the services in a discovery server.  `port: 8761`
* `admin-server`: used for registering all the services in a monitoring system server.  `port: 9390`
* `kafka`: which is a Kafka server for messages between `shop-cart-api` and `shop-validator`.  `port: 9092`
* `prometheus`: server to collect data about our services and save it.  `port: 9090`
* `graphana`: tool used for creating dashboards with `prometheus` data.  `port: 3000`

## Diagram
This is a visualization of the structure of the project until now.

![alt text](https://raw.githubusercontent.com/kevin-neves/java-microservices/main/ecommerceStructure.png)

## Features
* The system can be run using only one command through Docker Compose. 
* Each Java container is built using two steps:
1. The **.jar** file is compiled in a **Maven** image container.
2. Then **.jar** file is copied to a new lightweight **alpine-jre** image. The final container is about 200 MB in size.
* Each service is completely independent of others, and has it own schema on the database.
* Kafka is used for the communication between `shop-cart-api` and `shop-validator`.
* `shop-validator` uses Http requests for communication with other services to validate information.
* `prometheus` and `grafana` does the job of monitor the services.

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