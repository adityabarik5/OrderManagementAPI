package com.practice.orderapp.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderNameRequest {

    @Schema(example = "Gaming Laptop")
    @NotBlank(message = "Product name cannot be empty")
    private String name;
}