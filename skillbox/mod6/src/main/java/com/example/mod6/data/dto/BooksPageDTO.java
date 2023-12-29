package com.example.mod6.data.dto;
import  com.example.mod6.data.book.Book;
import lombok.Data;

import java.util.List;
@Data
public class BooksPageDTO {

    private Integer count;
    private List<Book> books;

    public BooksPageDTO(List<Book> books) {
        this.count = books.size();
        this.books = books;
    }
}
