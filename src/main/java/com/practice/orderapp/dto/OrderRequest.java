package com.practice.orderapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
public class OrderRequest {

    @Schema(example = "Laptop")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Schema(example = "2")
    @Positive(message = "Price must be greater than zero")
    private double price;

    @Schema(example = "75000")
    @Positive(message = "Quantity must be greater than zero")
    private int quantity;
}