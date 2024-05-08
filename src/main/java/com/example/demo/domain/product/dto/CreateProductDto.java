package com.example.demo.domain.product.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateProductDto {
    @NotBlank(message = "Code is required")
    private String code;

    @NotBlank(message = "Name is required")
    private String name;
    private String description;

    @NotBlank(message = "Category is required")
    private String category;
    private String brand;
    private String type;

    public CreateProductDto() {
    }

    public CreateProductDto(String code, String name, String description, String category, String brand, String type) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.type = type;
    }
}
