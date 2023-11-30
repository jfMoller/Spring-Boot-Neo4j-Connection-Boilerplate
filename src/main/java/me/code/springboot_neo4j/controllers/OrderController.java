package me.code.springboot_neo4j.controllers;

import me.code.springboot_neo4j.models.Order;
import me.code.springboot_neo4j.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    record PlaceOrderDto(String userId, String[] productIds) {
    }

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestBody PlaceOrderDto dto) {
        var result = orderService.placeOrder(dto.userId(), dto.productIds());
        return ResponseEntity.ok(result);
    }
}
