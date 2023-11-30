package me.code.springboot_neo4j.services;

import me.code.springboot_neo4j.models.Order;
import me.code.springboot_neo4j.models.Product;
import me.code.springboot_neo4j.models.User;
import me.code.springboot_neo4j.repositories.OrderRepository;
import me.code.springboot_neo4j.repositories.ProductRepository;
import me.code.springboot_neo4j.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            ProductRepository productRepository,
            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order placeOrder(String userId, String[] productIds) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<Product> orderedProducts = getProductsByIds(productIds);

        Order newOrder = new Order(user, orderedProducts);
        return orderRepository.save(newOrder);
    }

    private List<Product> getProductsByIds(String[] productIds) {
        List<Product> products = new ArrayList<>();
        for (var id : productIds) {
            var product = productRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Product with id: " + id + "not found"));
            products.add(product);
        }
        return products;
    }

    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }
}
