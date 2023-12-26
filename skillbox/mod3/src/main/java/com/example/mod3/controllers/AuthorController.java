package com.example.mod3.controllers;

import com.example.mod3.services.AuthorService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE, makeFinal = true)
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public String getAuthorsPage(Model model){
        model.addAttribute("authorService", authorService);
        model.addAttribute("letters", authorService.getAuthorsFirstLetters());
        return "authors/index";
    }

}
