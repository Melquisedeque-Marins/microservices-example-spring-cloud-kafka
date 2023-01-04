package com.melck.mckecomerce.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    private Long categoryId;
    private String name;
    private String description;
    private String imgUrl;
    private int qty;
    private double price;
}
