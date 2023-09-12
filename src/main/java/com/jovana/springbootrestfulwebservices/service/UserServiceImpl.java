package com.jovana.springbootrestfulwebservices.service;

import com.jovana.springbootrestfulwebservices.dto.UserDto;
import com.jovana.springbootrestfulwebservices.entity.User;
import com.jovana.springbootrestfulwebservices.mapper.ClassicUserMapper;
import com.jovana.springbootrestfulwebservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    @Override
    public UserDto createUser (UserDto userDto) {
        return ClassicUserMapper.mapToUserDto(userRepository.save(ClassicUserMapper.mapToUser(userDto)));
    }
    
    @Override
    public UserDto getUserById (Long id) {
        return ClassicUserMapper.mapToUserDto(userRepository.findById(id)
                                                            .orElseThrow());
    }
    
    @Override
    public List<UserDto> getAllUsers () {
        List<User> users = userRepository.findAll();
        return users.stream()
                    .map(ClassicUserMapper::mapToUserDto)
                    .collect(Collectors.toList());
    }
    
    @Override
    public UserDto updateUser (Long id, UserDto userDto) {
        
        User existingUser = userRepository.findById(id).orElseThrow();
        existingUser.setEmail(userDto.email());
        existingUser.setFirstName(userDto.firstName());
        existingUser.setLastName(userDto.lastName());
        return ClassicUserMapper.mapToUserDto(userRepository.save(existingUser));
        
    }
    
    @Override
    public void deleteUser (Long id) {
        userRepository.deleteById(id);
    }
}
