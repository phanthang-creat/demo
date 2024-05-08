package com.example.demo.domain.product.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductDto extends CreateProductDto {

    public UpdateProductDto() {
    }

    public UpdateProductDto(Long id, String code, String name, String description, String category, String brand, String type) {
        super(code, name, description, category, brand, type);
    }
}