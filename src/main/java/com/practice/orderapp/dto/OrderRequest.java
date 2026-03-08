package com.practice.orderapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class OrderRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Positive(message = "Price must be greater than zero")
    private double price;
}