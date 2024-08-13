package com.example.thi_thuc_hanh_module_4.services.impl;

import com.example.thi_thuc_hanh_module_4.models.Category;
import com.example.thi_thuc_hanh_module_4.repositories.ICategoryRepository;
import com.example.thi_thuc_hanh_module_4.services.ICategoryServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryServcie {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
