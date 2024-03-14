
package com.example.demo.controller;


import com.example.demo.dao.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@EntityScan
@Controller
@RequiredArgsConstructor
public class RegistrationUserController {
    private final UserService userService;
    private LoginUserController loginUserController;


    @GetMapping("/registration")
    public String postUsers(Model model) {
        model.addAttribute("user",new User());
        return "registration.html";
    }

    @RequestMapping(value = "/registration/create", method = RequestMethod.POST)
    public String addUsers(User user, Model model)
        /*if (!user.getLogin().isEmpty()
                & !user.getPassword().isEmpty()
                & !user.getEmail().isEmpty()
                & userService.checkSameLogin(user.getLogin()))*/
        {
            model.addAttribute("user", user);

            userService.saveUser(user);

            return "redirect:/logining"+ user.getId();
        }
       /* else if(userService.checkSameLogin(user.getLogin())) {
            model.addAttribute("error1", "Ошибка - Данный логин уже занят!");
            return "registration";
        }
        else {
            model.addAttribute("error2", "Ошибка - Не все поля заполнены!");
            return "registration";
        }*/




}

