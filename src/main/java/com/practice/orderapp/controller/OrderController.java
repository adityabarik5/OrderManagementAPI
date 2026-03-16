package com.practice.orderapp.controller;

import com.practice.orderapp.common.ApiResponse;
import com.practice.orderapp.dto.OrderRequest;
import com.practice.orderapp.dto.UpdateOrderNameRequest;
import com.practice.orderapp.dto.UpdateOrderStatusRequest;
import com.practice.orderapp.entity.Order;
import com.practice.orderapp.entity.OrderStatusHistory;
import com.practice.orderapp.repository.OrderStatusHistoryRepository;
import com.practice.orderapp.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "Order API", description = "Operations for managing orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderStatusHistoryRepository orderStatusHistoryRepository;

    @Operation(summary = "Create a new order", description = "Creates an order with product name, quantity and price")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Order> createOrder(@Valid @RequestBody OrderRequest request) {
        Order order = orderService.createOrder(request);
        return ApiResponse.success("Order created successfully", order);
    }

    @Operation(summary = "Fetch all orders with pagination and sorting")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Page<Order>> getAllOrders(@PageableDefault(size = 3, sort = "id") Pageable pageable) {

        Page<Order> orders = orderService.getAllOrders(pageable);

        return ApiResponse.success("Orders fetched successfully", orders);
    }

    @Operation(summary = "Fetch order details by ID")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Order> getOrder(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ApiResponse.success("Order fetched successfully", order);
    }

    @Operation(summary = "Delete an order by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ApiResponse.success("Order deleted successfully", null);
    }

    @Operation(summary = "Update the product name of an order")
    @PatchMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Order> updateOrderName(@PathVariable Long id, @Valid @RequestBody UpdateOrderNameRequest request) {

        Order updatedOrder = orderService.updateOrderName(id, request.getName());

        return ApiResponse.success("Order name updated successfully", updatedOrder);
    }

    @Operation(summary = "Update order status")
    @PatchMapping("/status/{id}")
    public ApiResponse<Order> updateOrderStatus(@PathVariable Long id, @Valid @RequestBody UpdateOrderStatusRequest request) {

        return ApiResponse.success("Order status updated successfully", orderService.updateOrderStatus(id, request.getStatus()));
    }

    @Operation(summary = "Fetch order history by ID")
    @GetMapping("/history/{id}")
    public ApiResponse<List<OrderStatusHistory>> getOrderHistory(@PathVariable Long id) {

        return ApiResponse.success("Order history fetched successfully", orderStatusHistoryRepository.findByOrderId(id));
    }
}