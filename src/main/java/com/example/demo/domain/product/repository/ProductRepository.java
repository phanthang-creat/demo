package com.example.demo.domain.product.repository;

import com.example.demo.domain.product.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByCode(String code);
}
