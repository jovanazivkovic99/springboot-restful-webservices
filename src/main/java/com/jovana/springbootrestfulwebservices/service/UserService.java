package com.jovana.springbootrestfulwebservices.service;

import com.jovana.springbootrestfulwebservices.dto.UserDto;
import com.jovana.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    
    UserDto createUser (UserDto user);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}
