package com.rest_microservice.rest_microservice.controller;

import com.rest_microservice.rest_microservice.ApiResponse;
import com.rest_microservice.rest_microservice.dto.LoginRequestDTO;
import com.rest_microservice.rest_microservice.dto.UserResponseDTO;
import com.rest_microservice.rest_microservice.model.User;
import com.rest_microservice.rest_microservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        User registerUser = userService.registerUser(user);
        return ResponseEntity.ok("user registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserResponseDTO>> login(@RequestBody LoginRequestDTO loginRequestDTO){
        UserResponseDTO  userResponseDTO=userService.loginUser(loginRequestDTO.getName(), loginRequestDTO.getPassword());
        ApiResponse<UserResponseDTO> response=new ApiResponse<>(1, userResponseDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>>getAllUsers(){
        List<UserResponseDTO> allAvailableUsers=userService.getAllUser();
        ApiResponse<List<UserResponseDTO>>response=new ApiResponse<>(1, allAvailableUsers);
        return ResponseEntity.ok(response);
    }
}
