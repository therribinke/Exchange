/*
package com.example.demo.controller;


import com.example.demo.dao.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationUserController {
    private final UserService userServiceRegistration;
    private final LoginUserController loginUserController;


    @GetMapping("/registration")
    public String postUsers() {
        return "registration";
    }
    @PostMapping("/registration/create")
    public String addUsers(User user, Model model){
        if (!user.getLogin().isEmpty()
                & !user.getPassword().isEmpty()
                & !user.getEmail().isEmpty()
                & !userServiceRegistration.checkSameLogin(user.getLogin()))
        {
            userServiceRegistration.saveUser(user);

            return "redirect:/logining"+ user.getId();
        }
        else if(userServiceRegistration.checkSameLogin(user.getLogin())) {
            model.addAttribute("error1", "Ошибка - Данный логин уже занят!");
            return "registration";
        }
        else {
            model.addAttribute("error2", "Ошибка - Не все поля заполнены!");
            return "registration";
        }


    }

}
*/
