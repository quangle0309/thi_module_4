package com.example.thi_thuc_hanh_module_4.repositories;

import com.example.thi_thuc_hanh_module_4.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
