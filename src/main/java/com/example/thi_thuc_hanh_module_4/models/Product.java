package com.example.thi_thuc_hanh_module_4.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
