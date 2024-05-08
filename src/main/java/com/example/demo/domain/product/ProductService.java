package com.example.demo.domain.product;

import com.example.demo.domain.product.dto.CreateProductDto;
import com.example.demo.domain.product.dto.UpdateProductDto;
import com.example.demo.domain.product.entities.ProductEntity;
import com.example.demo.domain.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    final ProductRepository productRepository;
    final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getProductById(int id) {
        return productRepository.findById((long) id).orElse(null);
    }

    @Override
    public ProductEntity getProductByCode(String code) {
        return productRepository.findByCode(code);
    }

    @Override
    public ProductEntity saveProduct(CreateProductDto dto) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        ProductEntity product = new ProductEntity();
        modelMapper.map(dto, product);
        return productRepository.save(product);
    }

    @Override
    public ProductEntity updateProduct(int id, UpdateProductDto dto) {
        return productRepository.findById((long) id).map(product -> {
            modelMapper.getConfiguration().setAmbiguityIgnored(true);
            modelMapper.map(dto, product);
            return productRepository.save(product);
        }).orElse(null);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById((long) id);
    }
}
