package me.code.springboot_neo4j.repositories;

import me.code.springboot_neo4j.models.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, String> {
}
