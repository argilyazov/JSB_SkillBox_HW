package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.mod2.exceptions.BookShelfLoginException;
import org.example.mod2.services.LoginService;
import org.example.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    public String authenticate(@Valid LoginForm loginFrom, BindingResult bindingResult) throws BookShelfLoginException {
        if (loginService.authenticate(loginFrom)) {
            return "redirect:/books/shelf";
        } else {
            throw new BookShelfLoginException("invalid username or password");
        }
    }

    @ExceptionHandler(BookShelfLoginException.class)
    public String handleError(Model model, BookShelfLoginException exception) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "errors/404";
    }
}
