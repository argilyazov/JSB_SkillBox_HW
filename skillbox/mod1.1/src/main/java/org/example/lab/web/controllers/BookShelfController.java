package org.example.lab.web.controllers;

import org.apache.log4j.Logger;
import org.example.lab.app.services.BookService;
import org.example.lab.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/books")
public class BookShelfController {

    private BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books/shelf";
    }

    @PostMapping("/remove")
    public String removeBook(@RequestParam(value = "bookIdToRemove") Integer bookIdToRemove) {
        try{
            bookService.removeBookById(bookIdToRemove);
        }catch (Exception e){
            return "redirect:/books/shelf?error";
        }
        return "redirect:/books/shelf";
    }


    @PostMapping("/removeByRegex")
    public String removeByRegex(@RequestParam(value = "queryRegex") String queryRegex) {
        bookService.removeBookByRegex(queryRegex);
        return "redirect:/books/shelf";
    }
}
