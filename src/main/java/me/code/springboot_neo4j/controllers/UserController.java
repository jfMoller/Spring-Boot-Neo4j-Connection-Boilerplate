package me.code.springboot_neo4j.controllers;

import me.code.springboot_neo4j.models.User;
import me.code.springboot_neo4j.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        var result = userService.getAllUsers();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User newUser) {
        var result = userService.addUser(newUser);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
