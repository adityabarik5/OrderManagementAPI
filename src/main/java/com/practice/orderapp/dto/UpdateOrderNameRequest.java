package com.practice.orderapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UpdateOrderNameRequest {

    @Schema(example = "Gaming Laptop")
    @NotBlank(message = "Product name cannot be empty")
    private String name;
}