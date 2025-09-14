package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.model.request.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User requestToEntity(RegisterRequest request) {
        return User.builder()
                .nama(request.getFullName())
                .username(request.getUsername().toLowerCase())
                .email(request.getEmail().toLowerCase())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }
}
