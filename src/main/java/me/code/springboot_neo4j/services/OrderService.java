package me.code.springboot_neo4j.services;

import me.code.springboot_neo4j.models.Order;
import me.code.springboot_neo4j.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order addOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }

    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }
}
