package com.practice.orderapp.controller;

import com.practice.orderapp.common.ApiResponse;
import com.practice.orderapp.dto.OrderRequest;
import com.practice.orderapp.dto.OrderResponse;
import com.practice.orderapp.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(@Valid @RequestBody OrderRequest request) {

        String id = service.createOrder(request);

        OrderResponse response = new OrderResponse("Order created successfully", id);

        ApiResponse<OrderResponse> apiResponse =
                new ApiResponse<>(true, "Order processed successfully", response, null);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(apiResponse);
    }
}