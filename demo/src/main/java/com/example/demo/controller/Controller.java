package com.example.demo.controller;

/*import com.example.demo.service.UserService;*/

import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class Controller {
    private final UserService userService;


    /*@GetMapping("/user")
    public List<User> getUsers() {
        return userService.listUsers();
    }*/



}





