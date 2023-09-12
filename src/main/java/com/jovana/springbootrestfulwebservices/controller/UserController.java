package com.jovana.springbootrestfulwebservices.controller;

import com.jovana.springbootrestfulwebservices.dto.UserDto;
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
    public UserDto createUser (@RequestBody UserDto user) {
        return userService.createUser(user);
    }
    
    @GetMapping("/{id}")
    public UserDto getUserById (@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @GetMapping
    public List<UserDto> getAllUsers () {
        return userService.getAllUsers();
    }
    
    @PutMapping("/{id}")
    public UserDto updateUser (@PathVariable Long id, @RequestBody UserDto userDto) {
        
        return userService.updateUser(id, userDto);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
