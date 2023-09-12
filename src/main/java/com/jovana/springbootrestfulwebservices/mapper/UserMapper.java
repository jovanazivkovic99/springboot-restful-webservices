package com.jovana.springbootrestfulwebservices.mapper;

import com.jovana.springbootrestfulwebservices.dto.UserDto;
import com.jovana.springbootrestfulwebservices.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    
    public static UserDto mapToUserDto (User user) {
        UserDto userDto = UserDto.builder()
                                 .id(user.getId())
                                 .firstName(user.getFirstName())
                                 .lastName(user.getLastName())
                                 .email(user.getEmail())
                                 .build();
        return userDto;
    }
    
    public static User mapToUser (UserDto userDto) {
        User user = new User(userDto.id(), userDto.firstName(), userDto.lastName(), userDto.email());
        return user;
    }
    
}
