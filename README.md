# Order Management REST API

A production-style **Spring Boot REST API** for managing orders with validation, logging, status workflow, pagination, and API documentation. This project demonstrates clean backend architecture and common enterprise patterns used in real-world Java applications.

---

# 🚀 Features

* Maven-based Spring Boot project
* Layered architecture (**Controller → Service → Repository**)
* RESTful CRUD APIs
* DTO validation using `@Valid`
* Global exception handling
* Custom exceptions
* Standard API response wrapper
* Request logging
* Correlation ID tracking using MDC
* SLF4J logging
* MySQL database integration
* JPA/Hibernate ORM
* Pagination and sorting support
* Swagger API documentation
* Order status workflow validation
* Order status history tracking
* Lombok to reduce boilerplate code

---

# 🏗️ Project Architecture

```
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
```

Additional supporting layers:

```
config
common
dto
entity
exception
interceptor
repository
service
```

---

# 📦 Tech Stack

* Java 8
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Maven
* Lombok
* Swagger / OpenAPI
* SLF4J Logging

---

# 📁 Project Structure

```
orderapp
│
├── config
│   └── SwaggerConfig
│
├── common
│   └── ApiResponse
│
├── controller
│   └── OrderController
│
├── dto
│   └── OrderRequest
│
├── entity
│   ├── Order
│   ├── OrderStatus
│   └── OrderStatusHistory
│
├── exception
│   ├── GlobalExceptionHandler
│   ├── OrderNotFoundException
│   └── InvalidOrderStatusException
│
├── interceptor
│   └── RequestLoggingInterceptor
│
├── repository
│   ├── OrderRepository
│   └── OrderStatusHistoryRepository
│
├── service
│   └── OrderService
│
└── OrderAppApplication
```

---

# 📌 API Endpoints

## Create Order

```
POST /orders
```

Creates a new order.

---

## Get Order by ID

```
GET /orders/{id}
```

Returns details of a specific order.

---

## Get All Orders (Pagination + Sorting)

```
GET /orders?page=0&size=10&sort=id,desc
```

Returns paginated list of orders.

---

## Update Order Name

```
PUT /orders/{id}/name
```

Updates the order product name.

---

## Update Order Status

```
PATCH /orders/{id}/status
```

Updates the order status while validating workflow transitions.

---

## Delete Order

```
DELETE /orders/{id}
```

Deletes an order.

---

# 🔄 Order Status Workflow

Orders follow a controlled status lifecycle:

```
CREATED → PROCESSING → SHIPPED → DELIVERED
```

Invalid transitions are rejected with a proper error response.

Example:

```
DELIVERED → PROCESSING ❌ (Not allowed)
```

Every status change is stored in **OrderStatusHistory** for tracking.

---

# 📊 Standard API Response Format

All APIs return a consistent response structure:

```json
{
  "success": true,
  "message": "Order fetched successfully",
  "data": {
    "id": 1,
    "productName": "Laptop",
    "quantity": 1,
    "status": "CREATED"
  }
}
```

---

# 📖 API Documentation

Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

It provides interactive documentation to test all endpoints.

---

# 🧾 Logging Features

The project includes structured logging with:

* Request logging interceptor
* Correlation ID for tracing requests
* SLF4J logging

Example log output:

```
[CorrelationID: 9f3a1] Incoming request: GET /orders/1
```

This helps trace requests across logs in distributed systems.

---

# ⚙️ Database Configuration

Update the database configuration in:

```
src/main/resources/application.properties
```

Example:

```
spring.datasource.url=jdbc:mysql://localhost:3306/orderdb
spring.datasource.username=root
spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# ▶️ Running the Application

### 1. Clone the Repository

```
git clone https://github.com/<your-username>/orderapp.git
```

### 2. Navigate to the project

```
cd orderapp
```

### 3. Run the application

```
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

# 🐳 Planned Improvement

The next planned enhancement is **Docker support**.

Docker will allow the application to run using containers without manual environment setup.

Planned additions:

* Dockerfile
* Docker Compose (Spring Boot + MySQL)
* One-command startup

Example (future):

```
docker-compose up
```

---

# 🎯 Learning Objectives of This Project

This project demonstrates:

* Building REST APIs with Spring Boot
* Clean backend architecture
* Proper exception handling
* Logging and request tracing
* API documentation with Swagger
* Database persistence with JPA
* Pagination and sorting
* Business workflow validation

---

# 📌 Future Enhancements

Possible improvements:

* Docker containerization
* Authentication (JWT / Spring Security)
* Unit testing with JUnit & Mockito
* Integration tests
* CI/CD pipeline
* API versioning
* Caching with Redis

---

# 👨‍💻 Aditya

Backend practice project focused on building production-ready REST APIs using Spring Boot.
