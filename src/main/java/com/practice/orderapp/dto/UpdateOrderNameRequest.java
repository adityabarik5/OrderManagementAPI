package com.practice.orderapp.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderNameRequest {

    @NotBlank(message = "Product name cannot be empty")
    private String name;
}