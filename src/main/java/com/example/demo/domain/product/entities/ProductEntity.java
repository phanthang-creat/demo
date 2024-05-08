package com.example.demo.domain.product.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 9)
    private String code;

    @Column(nullable = false, length = 90)
    private String name;

    @Column(nullable = false, length = 28)
    private String category;

    @Column(nullable = true, length = 28)
    private String brand;

    @Column(nullable = true, length = 21)
    private String type;

    @Column(nullable = true, length = 180)
    private String description;

    @CreationTimestamp
    private Instant created_at;

    @UpdateTimestamp
    private Instant updated_at;
}
