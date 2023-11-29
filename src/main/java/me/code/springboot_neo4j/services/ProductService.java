package me.code.springboot_neo4j.services;

import me.code.springboot_neo4j.models.Product;
import me.code.springboot_neo4j.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }
}
