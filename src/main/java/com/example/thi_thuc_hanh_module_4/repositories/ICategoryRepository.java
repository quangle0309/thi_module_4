package com.example.thi_thuc_hanh_module_4.repositories;

import com.example.thi_thuc_hanh_module_4.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
