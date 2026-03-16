package com.practice.orderapp.dto;

import com.practice.orderapp.entity.OrderStatus;

public class UpdateOrderStatusRequest {

    private OrderStatus status;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}