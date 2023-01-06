package com.melck.mckecomerce.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private Long categoryId;
    private String name;
    private String description;
    private String imgUrl;
    private int quantity;
    private double price;
}
