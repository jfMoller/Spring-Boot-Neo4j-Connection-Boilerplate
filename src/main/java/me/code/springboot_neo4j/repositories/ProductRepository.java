package me.code.springboot_neo4j.repositories;

import me.code.springboot_neo4j.models.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Optional;

public interface ProductRepository extends Neo4jRepository<Product, String> {
    @Query("MATCH (p:Product) WHERE p.id = $id RETURN p")
    Optional<Product> findById(String id);
}
