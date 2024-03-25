package com.example.demo.dto.request;


import lombok.Data;
@Data
public class UserDataRequest {
        private String login;
        private String password;
        private String email;
}
