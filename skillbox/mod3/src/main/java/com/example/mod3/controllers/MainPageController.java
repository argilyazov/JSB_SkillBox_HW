package com.example.mod3.controllers;

import com.example.mod3.services.AuthorService;
import com.example.mod3.services.BookService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE, makeFinal = true)
public class MainPageController {
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;

    @GetMapping("/main")
    public String getMainPage(Model model) {
        model.addAttribute("authorService", authorService);
        model.addAttribute("bookData", bookService.getBooksData());
        return "index";
    }
}
