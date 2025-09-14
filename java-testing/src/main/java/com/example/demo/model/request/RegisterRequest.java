package com.example.demo.model.request;

import com.example.demo.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String fullName;
    private String username;
    private String email;
    private String password;

    private Role role;  // enum Role, ROLE_USER atau ROLE_ADMIN
}
