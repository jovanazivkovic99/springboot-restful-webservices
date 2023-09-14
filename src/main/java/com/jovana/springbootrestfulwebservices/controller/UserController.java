package com.jovana.springbootrestfulwebservices.controller;

import com.jovana.springbootrestfulwebservices.dto.UserDto;
import com.jovana.springbootrestfulwebservices.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(
        name = "User Controller",
        description = "Operations related to user"
)
public class UserController {
    
    private final UserService userService;
    
    @Operation(
            summary = "Create user",
            description = "Save user to database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser (@Valid @RequestBody UserDto user) {
        return userService.createUser(user);
    }
    
    @Operation(
            summary = "Get user by id",
            description = "Get single user by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{id}")
    public UserDto getUserById (@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @Operation(
            summary = "Get all users by id",
            description = "Get all users by id from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping
    public List<UserDto> getAllUsers () {
        return userService.getAllUsers();
    }
    
    
    @Operation(
            summary = "Update user by id",
            description = "Update user in database by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("/{id}")
    public UserDto updateUser (@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        
        return userService.updateUser(id, userDto);
    }
    
    @Operation(
            summary = "Delete user by id",
            description = "Delete user in database by id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    
}
