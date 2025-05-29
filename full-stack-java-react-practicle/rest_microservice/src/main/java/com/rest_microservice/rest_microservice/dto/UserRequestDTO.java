package com.rest_microservice.rest_microservice.dto;

import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {
    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "email is required")
    private String email;

    public @NotBlank(message = "name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "name is required") String name) {
        this.name = name;
    }

    public @NotBlank(message = "email is required") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "email is required") String email) {
        this.email = email;
    }
}
