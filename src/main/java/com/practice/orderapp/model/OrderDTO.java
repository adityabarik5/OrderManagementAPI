package com.practice.orderapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private String id;
    private String name;
    private double price;
}