package com.example.thi_thuc_hanh_module_4.services;

import com.example.thi_thuc_hanh_module_4.models.Order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

public interface IOrderService {
    Page<Order> findAll(Pageable pageable);
    void updateOrder(Order order);
    Optional<Order> findById(Long id);

    Page<Order> findAllByDate(LocalDate startDate, LocalDate endDate, Pageable pageable);
}
