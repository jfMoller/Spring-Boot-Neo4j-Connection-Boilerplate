package me.code.springboot_neo4j.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Node("Product")
public class Product {
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    String id;
    private String name;
    private String description;
    private String imageUrl;
    private double price;

    public Product(String name, String description, String imageUrl, double price) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}
