package com.example.demo;

import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.response.AuthResponse;
import com.example.demo.service.Impl.AuthServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    private final AuthServiceImpl authService = new AuthServiceImpl(null, null, null, null);

    @Test
    void testLogin_ShouldReturnToken() {
        LoginRequest request = new LoginRequest();
        request.setUsername("daffa");
        request.setPassword("qwe123");
        AuthResponse response = authService.login(request);
        assertNotNull(response);
        assertNotNull(response.getToken());
    }
}
