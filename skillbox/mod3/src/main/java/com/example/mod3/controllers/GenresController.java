package com.example.mod3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/genres")
public class GenresController {

    @GetMapping
    public String getGenresPage(){
        return "genres/index";
    }

}
