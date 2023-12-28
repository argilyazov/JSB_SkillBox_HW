package com.example.mod5.controllers;

import com.example.mod5.data.author.Author;
import com.example.mod5.service.AuthorService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
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
