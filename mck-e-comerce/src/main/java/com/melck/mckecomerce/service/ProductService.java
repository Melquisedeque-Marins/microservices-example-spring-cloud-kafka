package com.melck.mckecomerce.service;

import com.melck.mckecomerce.dto.ProductRequest;
import com.melck.mckecomerce.dto.ProductResponse;
import com.melck.mckecomerce.service.exceptions.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.melck.mckecomerce.model.Product;
import com.melck.mckecomerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

import java.beans.BeanProperty;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {

    private final ProductRepository repository;

    public Product insert(ProductRequest request) {
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        log.info("Save a new product into the ProductService");
        return repository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        log.info("get all products into the ProductService");
        return repository.findAll().stream().map(this::mapToProductResponse).toList();
    }

    public ProductResponse getProductById(Long id) {
//        Optional<Product> product = repository.findById(id);
//        return product.orElseThrow(() -> new ObjectNotFoundException("Object with id" + id + "cannot be founded"));
        try {
            Product product = repository.findById(id).get();
            log.info("the product with id: " + id + " was founded.");
            return mapToProductResponse(product);
        } catch (NoSuchElementException e) {
            log.error("Case with id: " + id + " cannot be founded. " + e.getMessage(), e );
            throw new ObjectNotFoundException("Product with id: " + id + " cannot be founded.");
        }
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .description(product.getDescription())
                .imgUrl(product.getImgUrl())
                .build();
    }

    
}
