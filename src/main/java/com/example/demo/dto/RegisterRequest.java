package com.example.demo.dto;

import com.example.demo.entity.enums.RoleType;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private RoleType role;
}