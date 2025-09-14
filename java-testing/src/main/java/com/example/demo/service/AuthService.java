package com.example.demo.service;

import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.request.RegisterRequest;
import com.example.demo.model.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    String register(RegisterRequest request);
}
