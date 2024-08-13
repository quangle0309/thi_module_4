package com.example.thi_thuc_hanh_module_4.repositories;

import com.example.thi_thuc_hanh_module_4.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;


public interface IOrderRepository extends JpaRepository<Order, Long> {

        @Query("SELECT o FROM Order o WHERE DATE(o.purchaseDate) BETWEEN :startDate AND :endDate")
        Page<Order> findOrdersByPurchaseDateBetween(
                @Param("startDate") LocalDate startDate,
                @Param("endDate") LocalDate endDate,
                Pageable pageable);
}
