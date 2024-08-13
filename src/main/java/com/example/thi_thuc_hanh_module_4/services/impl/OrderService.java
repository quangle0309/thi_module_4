package com.example.thi_thuc_hanh_module_4.services.impl;

import com.example.thi_thuc_hanh_module_4.models.Order;
import com.example.thi_thuc_hanh_module_4.repositories.IOrderRepository;
import com.example.thi_thuc_hanh_module_4.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Page<Order> findAllByDate(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return orderRepository.findOrdersByPurchaseDateBetween(startDate, endDate, pageable);
    }
}
