package com.rest_microservice.rest_microservice.mapper;

import com.rest_microservice.rest_microservice.dto.UserRequestDTO;
import com.rest_microservice.rest_microservice.dto.UserResponseDTO;
import com.rest_microservice.rest_microservice.model.User;

public class UserMapper {
    public static User toEntity(UserRequestDTO requestDTO){
        User user=new User();
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());
        return user;
    }
    public static UserResponseDTO userResponseDTO(User user){
        UserResponseDTO dto=new UserResponseDTO();

        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
    public static UserResponseDTO toDTO(User user){
        UserResponseDTO dto=new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
