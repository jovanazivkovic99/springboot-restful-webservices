package com.jovana.springbootrestfulwebservices.service;

import com.jovana.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    
    User createUser (User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long id);
}
