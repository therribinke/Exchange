package com.example.demo.dto.request;


import lombok.Data;
@Data
public class UserRequest {
        private String login;
        private String password;
        private String email;
}
