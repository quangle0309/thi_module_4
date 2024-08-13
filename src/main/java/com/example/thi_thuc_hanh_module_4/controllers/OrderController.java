package com.example.thi_thuc_hanh_module_4.controllers;


import com.example.thi_thuc_hanh_module_4.models.Order;
import com.example.thi_thuc_hanh_module_4.services.ICategoryServcie;
import com.example.thi_thuc_hanh_module_4.services.IOrderService;
import com.example.thi_thuc_hanh_module_4.services.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Optional;

@Controller
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ICategoryServcie categoryService;
    @Autowired
    private IProductService productService;

    @GetMapping("/orders")
    public String getOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Order> ordersPage = orderService.findAll(pageable);

        model.addAttribute("ordersPage", ordersPage);
        return "index";
    }

    @GetMapping("/orders/update/{id}")
    public String editOrderForm(@PathVariable Long id, Model model) {
        Optional<Order> orderOpt = orderService.findById(id);
        if (orderOpt.isPresent()) {
            model.addAttribute("order", orderOpt.get());
            model.addAttribute("products", productService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            return "update";
        }
        return "redirect:/orders";
    }

    @PostMapping("/orders/update/{id}")
    public String updateOrder(@PathVariable Long id, @Valid Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.findAll());
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("order", order);
            return "update";
        }
        order.setId(id);
        orderService.updateOrder(order);
        return "redirect:/orders";
    }

    @PostMapping("orders/search")
    public String search(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate, @RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "10") int size, Model model) {
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("ordersPage", orderService.findAllByDate(startDate, endDate, pageable));
        return "index";
    }
}
