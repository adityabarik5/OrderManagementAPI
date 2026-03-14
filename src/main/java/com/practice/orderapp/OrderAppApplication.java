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
The project now includes:

✔ Maven project
✔ Spring Boot REST API
✔ Controller / Service / Repository architecture
✔ DTO validation
✔ Global exception handling
✔ SLF4J logging
✔ Correlation ID with MDC
✔ Request logging interceptor
✔ Standard API response wrapper
✔ Lombok for clean code
✔ MySQL + JPA integration

To be added:
1️⃣ Pagination + sorting
2️⃣ Swagger documentation
3️⃣ Docker container
4️⃣ Order status workflow
*/