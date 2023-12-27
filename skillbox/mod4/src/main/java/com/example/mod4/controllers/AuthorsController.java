package com.example.mod4.controllers;

import com.example.mod4.data.Author;
import com.example.mod4.data.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class AuthorsController {
    @Autowired
    private final AuthorService authorService;


    @ModelAttribute("authorsMap")
    public Map<String,List<Author>> authorsMap(){
        return authorService.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String getAuthors(){
        return "/authors/index";
    }
}
