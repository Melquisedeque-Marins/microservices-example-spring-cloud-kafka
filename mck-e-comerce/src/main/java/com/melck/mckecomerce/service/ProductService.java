package com.melck.mckecomerce.service;

import org.springframework.stereotype.Service;

import com.melck.mckecomerce.model.Product;
import com.melck.mckecomerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;

    public Product insert(Product product) {
        return repository.save(product);
    }
    
}
