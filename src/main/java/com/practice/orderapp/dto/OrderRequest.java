package com.practice.orderapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

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