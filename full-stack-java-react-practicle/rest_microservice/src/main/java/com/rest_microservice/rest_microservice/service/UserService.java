package com.rest_microservice.rest_microservice.service;

import com.rest_microservice.rest_microservice.dto.UserResponseDTO;
import com.rest_microservice.rest_microservice.exceptions.InvalidCredentialsException;
import com.rest_microservice.rest_microservice.mapper.UserMapper;
import com.rest_microservice.rest_microservice.model.User;
import com.rest_microservice.rest_microservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
        this.passwordEncoder=new BCryptPasswordEncoder();
    }
    public User registerUser(User user){
        String hashPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        return userRepository.save(user);
    }

    public UserResponseDTO loginUser(String name, String rawPassword){
        User user=userRepository.findByName(name).orElseThrow(()->new RuntimeException("User not found"));

        if(!passwordEncoder.matches(rawPassword, user.getPassword())){
            throw new InvalidCredentialsException("Invalid credentials");
        }
        UserResponseDTO dto=new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
//        return tasks.stream().map(TaskMapper::toDTO).toList();
    public List<UserResponseDTO> getAllUser(){
        List<User> allUsers=userRepository.findAll();
        for(User user:allUsers){
            System.out.println(user);
        }
        return allUsers.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

}
