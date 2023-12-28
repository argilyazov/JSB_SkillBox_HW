package com.example.mod5.controllers;

import com.example.mod5.data.book.Book;
import com.example.mod5.service.BookService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MainPageController {
    @Autowired
    private final BookService bookService;

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.getBooksData();
    }

    @ModelAttribute("newBooks")
    public List<Book> newBooks(){
        return bookService.getBooksData();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks(){
        return bookService.getBooksData();
    }

    @GetMapping("/")
    public String getMain(){
        return "index";
    }
}
