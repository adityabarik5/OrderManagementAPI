package com.practice.orderapp.service;

import com.practice.orderapp.dto.OrderRequest;
import com.practice.orderapp.entity.Order;
import com.practice.orderapp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(OrderRequest request) {

        Order order = new Order();

        order.setProductName(request.getName());
        order.setQuantity(request.getQuantity());
        order.setPrice(request.getPrice());
        order.setStatus("CREATED");

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
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
}