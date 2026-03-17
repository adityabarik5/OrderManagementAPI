package com.practice.orderapp.service;

import com.practice.orderapp.dto.OrderRequest;
import com.practice.orderapp.entity.Order;
import com.practice.orderapp.entity.OrderStatus;
import com.practice.orderapp.entity.OrderStatusHistory;
import com.practice.orderapp.exception.InvalidOrderStatusException;
import com.practice.orderapp.exception.OrderNotFoundException;
import com.practice.orderapp.repository.OrderRepository;
import com.practice.orderapp.repository.OrderStatusHistoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderStatusHistoryRepository orderStatusHistoryRepository;

    public Order createOrder(OrderRequest request) {

        Order order = new Order();

        order.setProductName(request.getName());
        order.setQuantity(request.getQuantity());
        order.setPrice(request.getPrice());

        order.setStatus(OrderStatus.CREATED);

        Order savedOrder = orderRepository.save(order);

        OrderStatusHistory history = new OrderStatusHistory(savedOrder.getId(),OrderStatus.CREATED);
        orderStatusHistoryRepository.save(history);

        return savedOrder;
    }

    @Operation(summary = "Fetch all orders with pagination and sorting")
    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrderName(Long id, String name) {

        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        order.setProductName(name);

        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Long id, OrderStatus newStatus) {

        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        OrderStatus currentStatus = order.getStatus();

        if (!currentStatus.canTransitionTo(newStatus)) {
            throw new InvalidOrderStatusException("Invalid status transition from " + currentStatus + " to " + newStatus);
        }

        order.setStatus(newStatus);
        Order updatedOrder = orderRepository.save(order);

        // save history
        OrderStatusHistory history = new OrderStatusHistory(id, currentStatus, newStatus);
        orderStatusHistoryRepository.save(history);

        return updatedOrder;
    }
}