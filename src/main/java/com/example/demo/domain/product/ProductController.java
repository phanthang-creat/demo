package com.example.demo.domain.product;

import com.example.demo.domain.product.dto.CreateProductDto;
import com.example.demo.domain.product.dto.UpdateProductDto;
import com.example.demo.domain.product.entities.ProductEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/product")
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<ProductEntity> index() {
        return productService.getAllProducts();
    }

    @GetMapping("/{code}")
    public ProductEntity getProduct(@PathVariable String code) {
        return productService.getProductByCode(code);
    }

    @PostMapping("")
    public ProductEntity createProduct(@Valid @RequestBody CreateProductDto dto) {
        return productService.saveProduct(dto);
    }

    @PutMapping("/{id}")
    public ProductEntity updateProduct(@PathVariable int id, @Valid @RequestBody UpdateProductDto dto) {
        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
