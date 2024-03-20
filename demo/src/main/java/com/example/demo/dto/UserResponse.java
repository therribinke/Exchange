package com.example.demo.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Integer id;

    private String login;
    private String password;
    private String email;
}
