/*
package com.example.demo.controller;

import com.example.demo.dao.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginUserController {
    private final UserService userService;

    @GetMapping("/logining{id}")
    public String loginiUserSuccessfully(Model model,@PathVariable Long id){

        model.addAttribute("client", userService.getUserByID(id));

        return "loginingSuccessfully";
    }

    @GetMapping("/login")
    public String loginUser(){
        return"login";
    }
    @PostMapping("/login/check")
    public String checkUserLogin(User user, Model model){
        if(userService.getPasswordByLogin(user.getLogin()).equals(user.getPassword())) {
            return "redirect:/logining"+ userService.getIDByLogin(user.getLogin());
        }
        else {
            model.addAttribute("error3", "Ошибка - Неправильный логин или пароль!");
            return "login";
        }
    }
}
*/
