package com.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class HomePage {

    @GetMapping("/")
    public String redirHomePage() {
        return "redirect:/homepage";
    }
    @GetMapping("/homepage")
    public String homePage() {
        return "homepage";
    }
}
