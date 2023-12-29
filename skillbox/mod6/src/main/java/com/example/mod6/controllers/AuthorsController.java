package com.example.mod6.controllers;

import com.example.mod6.data.author.Author;
import com.example.mod6.service.AuthorService;
import com.example.mod6.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@Api(description = "authors data")
@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class AuthorsController {
    @Autowired
    final AuthorService authorService;
    @Autowired
    BookService bookService;

    @ModelAttribute("authorsMap")
    public Map<String,List<Author>> authorsMap(){
        return authorService.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String getAuthorsPage(){
        return "/authors/index";
    }

    @GetMapping("/authors/{slug}")
    public String getAuthorsPageBySlug(@PathVariable String slug, Model model){

        var author = authorService.getAuthorBySlug(slug);
        var booksList = bookService.getBooksByAuthor(author,0,6);
        var countBooksByAuthor=bookService.countByAuthor(author);

        model.addAttribute("author",author);
        model.addAttribute("booksList",booksList);
        model.addAttribute("countBooksByAuthor",countBooksByAuthor);

        return "/authors/slug";
    }
    @GetMapping("/books/author/{authorSlug}")
    public String getAuthorBooks(@PathVariable String authorSlug, Model model){

        var author = authorService.getAuthorBySlug(authorSlug);
        var booksList = bookService.getRecentBooksByAuthor(author,0,20);

        model.addAttribute("author",author);
        model.addAttribute("booksList",booksList);

        return "/books/author";
    }




    @ApiOperation("method to get map of authors")
    @GetMapping("/api/authors")
    @ResponseBody
    public Map<String,List<Author>> authors(){
        return authorService.getAuthorsMap();
    }
}
