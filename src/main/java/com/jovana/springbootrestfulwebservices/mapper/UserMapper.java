package com.jovana.springbootrestfulwebservices.mapper;

import com.jovana.springbootrestfulwebservices.dto.UserDto;
import com.jovana.springbootrestfulwebservices.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    
    UserDto userToUserDto (User user);
    
    User userDtoToUser (UserDto userDto);
}
