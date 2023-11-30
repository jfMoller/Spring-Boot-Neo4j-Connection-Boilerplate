## **Spring-Boot-Neo4j-Connection-Boilerplate**

### Introduction

I wanted to put together some simple boilerplate for setting up a connection between Java Spring Boot and the Neo4j
graph database.

### Description

This project provides a backend for setting up a connection to Neo4J with example models, controllers, services and
repositories; it could be used as a starting reference for building API:s with Neo4j.

### How to Run Locally

1. **Download the project:**


2. [**Set up a free AuraDB instance**](https://neo4j.com/cloud/platform/aura-graph-database/) (or host your own database locally)


3. **Get and set the connection details for your instance**

   ```
   NEO4J_URI=<your_uri>
   NEO4J_USERNAME=neo4j
   NEO4J_PASSWORD=<your_password>
   AURA_INSTANCEID=<your_instance_id>
   AURA_INSTANCENAME=<your_instance_name>
   ```
   cd src/main/resources/    
   Paste the required details into your application.yml file
   ```
   spring:
     neo4j:
       uri: <your_uri>
       authentication:
         username: neo4j
         password: <your_password>
   ```

4. **Run the Spring Boot Application in your IDE**


5. **Verify that the endpoints are functioning as intended, for example by
   using [**Postman**](https://www.postman.com/downloads/)**

### Endpoints

**Add user**

```
Method: POST
Endpoint: http://localhost:8080/user/add
JSON: 
{
    "username": "Example_user",
    "email": "example@example.com",
    "password": "example_password"
}
```

**Add product**

```
Method: POST
Endpoint: http://localhost:8080/product/add
JSON: 
{
    "name": "Example_product",
    "description": "abc",
    "imageUrl": "http://example_img.com",
    "price": 100.00
}
```

**Add order**

```
Method: POST
Endpoint: http://localhost:8080/order/place
JSON: 
{
    "userId": "your_user_id",
    "productIds": [
        "product_id_1",
        "product_id_2"
    ]
}
```    
  
    
