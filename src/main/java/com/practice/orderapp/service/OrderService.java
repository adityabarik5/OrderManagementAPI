package com.practice.orderapp.service;

import com.practice.orderapp.dto.OrderRequest;
import com.practice.orderapp.model.Order;
import com.practice.orderapp.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public String createOrder(OrderRequest request) {
        String orderId = UUID.randomUUID().toString();

        Order order = new Order();
        order.setId(orderId);
        order.setName(request.getName());
        order.setPrice(request.getPrice());

        log.info("Processing order {}", order.getId());
        repository.saveOrder(order);
        log.info("Order saved {}", order.getId());

        return order.getId();
    }
}