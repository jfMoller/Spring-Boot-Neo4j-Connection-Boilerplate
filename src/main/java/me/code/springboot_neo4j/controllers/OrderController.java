package me.code.springboot_neo4j.controllers;

import me.code.springboot_neo4j.models.Order;
import me.code.springboot_neo4j.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        var result = orderService.getAllOrders();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order newOrder) {
        var result = orderService.addOrder(newOrder);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
    }
}
