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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BooksController {
    @Autowired
    private BookService bookService;

    @GetMapping("recent")
    public String getRecentPage(){
        return "books/recent";
    }

    @GetMapping("popular")
    public String getPopularPage(){
        return "books/popular";
    }

    @ModelAttribute("booksList")
    public List<Book> bookList(){
        return bookService.getBooksData();
    }
}
