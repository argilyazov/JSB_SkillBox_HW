package com.example.mod6.controllers;

import com.example.mod6.data.book.Book;
import com.example.mod6.data.dto.BooksPageDTO;
import com.example.mod6.data.dto.SearchWordDTO;
import com.example.mod6.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private BookService bookService;

    @Autowired
    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("searchWordDTO")
    public SearchWordDTO searchWordDTO(){
        return new SearchWordDTO();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults(){
        return new ArrayList<>();
    }

    @GetMapping(value = {"/","/{searchWord}"})
    public String getSearchResult(@PathVariable(required = false, value = "searchWord") SearchWordDTO searchWordDTO, Model model){
        model.addAttribute("searchWordDTO",searchWordDTO);
        model.addAttribute("searchResults",bookService.getPageOfSearchResultBooks(searchWordDTO.getExample(),0,20).getContent());

        return "search/index";
    }
}
