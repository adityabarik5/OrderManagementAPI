package com.practice.orderapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderAppApplication.class, args);
    }
}

/*
✔ Maven project setup using Apache Maven
✔ REST API built with Spring Boot
✔ Layered architecture (Controller → Service → Repository)
✔ DTO-based request handling with validation
✔ Global exception handling with custom exceptions
✔ SLF4J logging
✔ Correlation ID tracking using MDC
✔ Request correlation filter
✔ Request logging interceptor
✔ Standardized API response wrapper (ApiResponse<T>)
✔ Lombok to reduce boilerplate
✔ MySQL integration with Hibernate via JPA
✔ Pagination and sorting for order retrieval
✔ API documentation using Swagger UI
✔ Order status workflow with transition validation
✔ Order status history tracking (audit trail)
✔ Docker container
Swagger available at: http://localhost:8080/swagger-ui/index.html
*/