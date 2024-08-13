package com.example.thi_thuc_hanh_module_4.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "purchase_date", nullable = false)
    @NotNull(message = "Ngày mua không được để trống")
    @Future(message = "Ngày mua phải lớn hơn ngày hiện tại")
    private LocalDateTime purchaseDate;

    @Column(name = "quantity", nullable = false)
    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 1, message = "Số lượng phải là số nguyên dương")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
