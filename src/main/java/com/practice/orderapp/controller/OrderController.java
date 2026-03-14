package com.practice.orderapp.controller;

import com.practice.orderapp.common.ApiResponse;
import com.practice.orderapp.dto.OrderRequest;
import com.practice.orderapp.dto.UpdateOrderNameRequest;
import com.practice.orderapp.entity.Order;
import com.practice.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@Valid @RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders() { return orderService.getAllOrders(); }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully";
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Order> updateOrderName(
            @PathVariable Long id,
            @Valid @RequestBody UpdateOrderNameRequest request) {

        Order updatedOrder = orderService.updateOrderName(id, request.getName());

        return ApiResponse.success("Order name updated successfully", updatedOrder);
    }
}