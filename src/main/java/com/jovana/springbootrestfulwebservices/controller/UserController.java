package com.jovana.springbootrestfulwebservices.controller;

import com.jovana.springbootrestfulwebservices.entity.User;
import com.jovana.springbootrestfulwebservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser (@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @GetMapping("/{id}")
    public User getUserById (@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @GetMapping
    public List<User> getAllUsers () {
        return userService.getAllUsers();
    }
    
    @PutMapping("/{id}")
    public User updateUser (@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        return userService.updateUser(user);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
