package com.practice.orderapp.repository;

import com.practice.orderapp.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public void saveOrder(Order order) {
        if(order.getName().equals("fail")) {
            throw new RuntimeException("Database error");
        }
    }
}