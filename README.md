# Order Management API

A simple RESTful Order Management backend built using Java and Spring Boot.
This project demonstrates common backend engineering practices such as layered architecture, validation, standardized API responses, pagination, and order lifecycle management.

---

## Features

* Create orders
* Retrieve orders (single or paginated list)
* Update order name
* Update order status
* Delete orders
* Order status lifecycle with transition validation
* Global exception handling
* Request validation
* Standard API response wrapper
* Pagination and sorting
* Swagger API documentation
* Logging with correlation ID support

---

## Tech Stack

* Java 8
* Spring Boot 2.7
* Spring Web
* Spring Data JPA
* Hibernate
* Maven
* MySQL
* Swagger (OpenAPI) for API documentation

---

## Project Structure

```
com.practice.orderapp
│
├── controller        # REST controllers
├── service           # Business logic
├── repository        # Data access layer
├── dto               # Request/Response DTOs
├── model             # Entities and enums
├── common            # ApiResponse wrapper, utilities
└── config            # Configuration classes
```

---

## Order Lifecycle

Orders follow a controlled status lifecycle.

```
CREATED → CONFIRMED → SHIPPED → DELIVERED
     ↓
  CANCELLED
```

Allowed transitions:

* CREATED → CONFIRMED
* CREATED → CANCELLED
* CONFIRMED → SHIPPED
* CONFIRMED → CANCELLED
* SHIPPED → DELIVERED

Invalid transitions are rejected by the API.

---

## API Endpoints

### Create Order

```
POST /orders
```

Example request:

```json
{
  "productName": "Laptop",
  "quantity": 2,
  "price": 75000
}
```

---

### Get All Orders

```
GET /orders?page=0&size=10&sort=price,desc
```

Supports pagination and sorting.

---

### Get Order By ID

```
GET /orders/{id}
```

---

### Update Order Name

```
PATCH /orders/{id}/name
```

Example request:

```json
{
  "name": "Gaming Laptop"
}
```

---

### Update Order Status

```
PATCH /orders/{id}/status
```

Example request:

```json
{
  "status": "CONFIRMED"
}
```

Available statuses:

```
CREATED
CONFIRMED
SHIPPED
DELIVERED
CANCELLED
```

---

### Delete Order

```
DELETE /orders/{id}
```

---

## Running the Application

Clone the repository:

```
git clone https://github.com/your-username/order-management-api.git
cd order-management-api
```

Run the application:

```
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## API Documentation

Swagger UI is available at:

```
http://localhost:8080/swagger-ui.html
```

This interface allows you to explore and test all endpoints directly from the browser.

---

## Example API Response Format

All responses follow a standardized structure:

```json
{
  "success": true,
  "message": "Order fetched successfully",
  "data": {
    "id": 1,
    "productName": "Laptop",
    "quantity": 2,
    "price": 75000,
    "status": "CREATED"
  },
  "errors": null
}
```

---

## Future Improvements

* Order status history tracking
* Unit tests (JUnit + Mockito)
* Docker containerization
* Authentication and authorization
* API versioning
* Rate limiting

---

## Author

Developed as a backend practice project to demonstrate modern Spring Boot API design.
