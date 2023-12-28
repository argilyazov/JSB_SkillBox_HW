package com.example.mod5.service;

import com.example.mod5.data.book.Book;
import com.example.mod5.repository.BookRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooksData() {
        return bookRepository.findAll();
    }

}
