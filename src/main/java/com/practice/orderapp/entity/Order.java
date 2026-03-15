package com.practice.orderapp.entity;

import com.practice.orderapp.model.OrderStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private int quantity;
    private double price;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}