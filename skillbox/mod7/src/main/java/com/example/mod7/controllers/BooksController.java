package com.example.mod7.controllers;

import com.example.mod7.data.book.Book;
import com.example.mod7.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookService bookService;



    @Autowired
    private BookRatingService bookRatingService;

    @Autowired
    private BooksRatingAndPopularityService booksRatingAndPopularityService;

    @Autowired
    private BookReviewService bookReviewService;


    @GetMapping("recent")
    public String recentPage(Model model) throws ParseException {
        model.addAttribute("recentBookList",recentBookList());
        return "books/recent";
    }

    @GetMapping("popular")
    public String popularPage(Model model) {
        model.addAttribute("booksList", booksRatingAndPopularityService.getPageOfPopularBooks(0, 5).getContent());
        return "books/popular";
    }



    public List<Book> recentBookList() throws ParseException {
        var simpleDateFormat = new SimpleDateFormat("dd.MM.yyy");
        var from = simpleDateFormat.parse("01.01.2000");
        var to = simpleDateFormat.parse("01.01.2016");
        return bookService.getPageOfBooksDataByPubDate(from, to, 0, 10).getContent();
    }

    @GetMapping("/{slug}")
    private String getBookBySlug(@PathVariable(required = true) String slug, Model model){
        var bookOpt = bookService.findBySlug(slug);

        if(bookOpt.isEmpty())
            return "redirect:/";

        var reviewsDTO = bookReviewService.getReviewByBook(bookOpt.get());

        var book = bookOpt.get();
        var bookRatingDTO = bookRatingService.getRatingByBook(book);

        model.addAttribute("book",book);
        model.addAttribute("IsTagsEmpty",book.getBook2Tags()==null);
        model.addAttribute("rating",bookRatingDTO);
        model.addAttribute("reviews",reviewsDTO);
        return "books/slug";
    }
}
