package me.code.springboot_neo4j.repositories;

import me.code.springboot_neo4j.models.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProductRepository extends Neo4jRepository<Product, String> {
}
