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

To be added:
1️⃣ MySQL + JPA integration
2️⃣ Pagination + sorting
3️⃣ Swagger documentation
4️⃣ Docker container
5️⃣ Order status workflow
*/