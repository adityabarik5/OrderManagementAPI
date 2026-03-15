package com.practice.orderapp.service;

import com.practice.orderapp.dto.OrderRequest;
import com.practice.orderapp.entity.Order;
import com.practice.orderapp.model.OrderStatus;
import com.practice.orderapp.repository.OrderRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(OrderRequest request) {

        Order order = new Order();

        order.setProductName(request.getName());
        order.setQuantity(request.getQuantity());
        order.setPrice(request.getPrice());

        order.setStatus(OrderStatus.CREATED);

        return orderRepository.save(order);
    }

    @Operation(summary = "Fetch all orders with pagination and sorting")
    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrderName(Long id, String name) {

        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id " + id));

        order.setProductName(name);

        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Long id, OrderStatus newStatus) {

        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

        OrderStatus currentStatus = order.getStatus();

        if (!currentStatus.canTransitionTo(newStatus)) {
            throw new RuntimeException("Invalid status transition from " + currentStatus + " to " + newStatus);
        }

        order.setStatus(newStatus);

        return orderRepository.save(order);
    }
}