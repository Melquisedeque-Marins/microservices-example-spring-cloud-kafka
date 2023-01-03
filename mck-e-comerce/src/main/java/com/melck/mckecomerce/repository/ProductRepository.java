package com.melck.mckecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melck.mckecomerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
