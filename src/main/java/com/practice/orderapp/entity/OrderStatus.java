package com.practice.orderapp.entity;

import java.util.Arrays;

public enum OrderStatus {

    CREATED, CONFIRMED, SHIPPED, DELIVERED, CANCELLED;

    public boolean canTransitionTo(OrderStatus newStatus) {

        switch (this) {

            case CREATED:
                return Arrays.asList(CONFIRMED, CANCELLED).contains(newStatus);

            case CONFIRMED:
                return Arrays.asList(SHIPPED, CANCELLED).contains(newStatus);

            case SHIPPED:
                return newStatus == DELIVERED;

            case DELIVERED:
            case CANCELLED:
                return false;

            default:
                return false;
        }
    }
}