package com.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
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
