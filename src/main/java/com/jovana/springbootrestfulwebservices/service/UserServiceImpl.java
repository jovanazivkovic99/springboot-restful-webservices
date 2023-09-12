package com.jovana.springbootrestfulwebservices.service;

import com.jovana.springbootrestfulwebservices.dto.UserDto;
import com.jovana.springbootrestfulwebservices.entity.User;
import com.jovana.springbootrestfulwebservices.mapper.ClassicUserMapper;
import com.jovana.springbootrestfulwebservices.mapper.UserMapper;
import com.jovana.springbootrestfulwebservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    @Override
    public UserDto createUser (UserDto userDto) {
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));
    }
    
    @Override
    public UserDto getUserById (Long id) {
        return userMapper.userToUserDto(userRepository.findById(id)
                                                            .orElseThrow());
    }
    
    @Override
    public List<UserDto> getAllUsers () {
        List<User> users = userRepository.findAll();
        return users.stream()
                    .map(userMapper::userToUserDto)
                    .collect(Collectors.toList());
    }
    
    @Override
    public UserDto updateUser (Long id, UserDto userDto) {
        
        User existingUser = userRepository.findById(id).orElseThrow();
        existingUser.setEmail(userDto.email());
        existingUser.setFirstName(userDto.firstName());
        existingUser.setLastName(userDto.lastName());
        return userMapper.userToUserDto(userRepository.save(existingUser));
        
    }
    
    @Override
    public void deleteUser (Long id) {
        userRepository.deleteById(id);
    }
}
