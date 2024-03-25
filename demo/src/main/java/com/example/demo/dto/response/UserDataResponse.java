package com.example.demo.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDataResponse {
    private Long id;

    private String login;
    private String password;
    private String email;
}
