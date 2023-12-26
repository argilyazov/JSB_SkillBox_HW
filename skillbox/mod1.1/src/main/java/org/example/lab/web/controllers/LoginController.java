package org.example.lab.web.controllers;

import org.apache.log4j.Logger;
import org.example.lab.app.services.LoginService;
import org.example.lab.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login_page";
    }

    @PostMapping("/auth")
    public String authenticate(LoginForm loginFrom) {
        if (loginService.authenticate(loginFrom)) {
            return "redirect:/books/shelf";
        } else {
            return "redirect:/login";
        }
    }
}
