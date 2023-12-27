package com.example.mod4.controllers;

import com.example.mod4.data.Book;
import com.example.mod4.data.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BooksController {
    @Autowired
    private BookService bookService;

    @GetMapping("recent")
    public String getRecent(){
        return "books/recent";
    }

    @GetMapping("popular")
    public String getPopular(){
        return "books/popular";
    }

    @ModelAttribute("booksList")
    public List<Book> bookList(){
        return bookService.getBooksData();
    }
}
