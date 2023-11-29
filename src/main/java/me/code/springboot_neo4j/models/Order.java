package me.code.springboot_neo4j.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.List;

@Getter
@NoArgsConstructor
@Node("Order")
public class Order {
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    String id;
    @Relationship("ORDERED_BY")
    User user;
    @Relationship("ORDERED")
    List<Product> products;

    public Order(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }
}
