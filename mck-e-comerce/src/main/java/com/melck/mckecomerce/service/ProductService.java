package com.melck.mckecomerce.service;

import com.melck.mckecomerce.dto.ProductRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.melck.mckecomerce.model.Product;
import com.melck.mckecomerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

import java.beans.BeanProperty;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;

    public Product insert(ProductRequest request) {
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
//        Product product1 = Product.builder()
//                .name(request.getName())
//                .qty(request.getQty())
//                .price(request.getPrice())
//                .description(request.getDescription())
//                .imgUrl(request.getImgUrl())
//                .build();
        return repository.save(product);
    }



    
}
