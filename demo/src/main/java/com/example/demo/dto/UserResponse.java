package com.example.demo.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Long id;

    private String login;
    private String password;
    private String email;
}
