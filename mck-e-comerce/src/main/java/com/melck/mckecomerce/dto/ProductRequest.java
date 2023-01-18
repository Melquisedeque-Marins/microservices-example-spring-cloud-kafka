package com.melck.mckecomerce.dto;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    private Long categoryId;

    @NotBlank(message = "Insert a valid name for the product")
    private String name;

    @NotBlank(message = "Insert a valid name for the product")
    private String description;
    private String imgUrl;
    private int quantity;
    @NotNull(message = "Insert a value for the product price")
    @NegativeOrZero(message = "Insert a valid value for the product price")
    private double price;
}
