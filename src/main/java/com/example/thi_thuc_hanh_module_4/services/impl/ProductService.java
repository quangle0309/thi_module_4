package com.example.thi_thuc_hanh_module_4.services.impl;

import com.example.thi_thuc_hanh_module_4.models.Product;
import com.example.thi_thuc_hanh_module_4.repositories.IProductRepository;
import com.example.thi_thuc_hanh_module_4.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
