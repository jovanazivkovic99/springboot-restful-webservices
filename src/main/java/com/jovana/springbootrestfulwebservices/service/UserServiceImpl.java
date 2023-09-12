package com.jovana.springbootrestfulwebservices.service;

import com.jovana.springbootrestfulwebservices.entity.User;
import com.jovana.springbootrestfulwebservices.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    @Override
    public User createUser (User user) {
        return userRepository.save(user);
    }
    
    @Override
    public User getUserById (Long id) {
        return userRepository.findById(id).orElseThrow();
    }
    
    @Override
    public List<User> getAllUsers () {
        return userRepository.findAll();
    }
    
    @Override
    public User updateUser (User user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow();
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        return userRepository.save(existingUser);
    }
    
    @Override
    public void deleteUser (Long id) {
        userRepository.deleteById(id);
    }
}
