package com.example.mod3.services;

import com.example.mod3.data.Book;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> getBooksData(){

        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int e)->{
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthorId(rs.getInt("author_id"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getInt("price_old"));
            book.setPrice(rs.getInt("price"));
            return book;
        });
        return new ArrayList<>(books);
    }
}
