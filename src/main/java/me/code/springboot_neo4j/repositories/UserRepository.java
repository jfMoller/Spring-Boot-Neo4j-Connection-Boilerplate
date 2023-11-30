package me.code.springboot_neo4j.repositories;

import me.code.springboot_neo4j.models.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, String> {
    @Query("MATCH (u:User) WHERE u.id = $id RETURN u")
    Optional<User> findById(String id);
}
