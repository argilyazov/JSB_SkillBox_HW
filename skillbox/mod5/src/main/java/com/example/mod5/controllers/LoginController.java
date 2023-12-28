package com.example.mod5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/signin")
    public String getLoginPage(){
        return "signin";
    }
}
