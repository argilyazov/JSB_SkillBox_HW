package com.example.mod6.controllers;

import com.example.mod6.data.book.Book;
import com.example.mod6.service.BookService;
import com.example.mod6.service.BooksRatingAndPopulatityService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/books")
@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class BooksController {
    @Autowired
    BookService bookService;

    @Autowired
    BooksRatingAndPopulatityService booksRatingAndPopulatityService;

    @GetMapping("recent")
    public String getRecentPage() {
        return "books/recent";
    }

    @GetMapping("popular")
    public String getPopularPage() {
        return "books/popular";
    }


    @ModelAttribute("booksList")
    public List<Book> bookList() {
        return booksRatingAndPopulatityService.getPageOfPopularBooks(0, 5).getContent();
    }

    @ModelAttribute("recentBookList")
    public List<Book> recentBookList() throws ParseException {
        var simpleDateFormat = new SimpleDateFormat("dd.MM.yyy");
        var from = simpleDateFormat.parse("01.01.2000");
        var to = simpleDateFormat.parse("01.01.2016");
        return bookService.getPageOfBooksDataByPubDate(from, to, 0, 10).getContent();
    }
}
