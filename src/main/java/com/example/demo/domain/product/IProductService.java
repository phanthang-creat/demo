package com.example.demo.domain.product;

import com.example.demo.domain.product.dto.CreateProductDto;
import com.example.demo.domain.product.dto.UpdateProductDto;
import com.example.demo.domain.product.entities.ProductEntity;

import java.util.List;

public interface IProductService {
    List<ProductEntity> getAllProducts();
    ProductEntity getProductById(int id);
    ProductEntity getProductByCode(String code);
    ProductEntity saveProduct(CreateProductDto product);
    ProductEntity updateProduct(int id, UpdateProductDto product);
    void deleteProduct(int id);
}
