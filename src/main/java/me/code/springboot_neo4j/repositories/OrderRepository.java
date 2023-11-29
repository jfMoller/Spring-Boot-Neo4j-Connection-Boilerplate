package me.code.springboot_neo4j.repositories;

import me.code.springboot_neo4j.models.Order;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface OrderRepository extends Neo4jRepository<Order, String> {
}
