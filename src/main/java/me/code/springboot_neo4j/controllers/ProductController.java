package me.code.springboot_neo4j.controllers;

import me.code.springboot_neo4j.models.Product;
import me.code.springboot_neo4j.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        var result = productService.getAllProducts();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
        var result = productService.addProduct(newProduct);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
    }
}
