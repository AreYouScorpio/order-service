package com.webshop.order.controller;

import com.webshop.order.model.Order;
import com.webshop.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Create new order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    // New /send endpoint for testing communication
    @PostMapping("/send")
    public String sendOrder(@RequestBody Order order) {
        orderRepository.save(order);  // Simulate saving the order
        return "Order Sent: " + order.getId();
    }
}
