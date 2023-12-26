package com.example.mod3.services;

import com.example.mod3.data.Author;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Author> getAuthorsData() {

        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet set, int e) -> {
            var author = new Author();
            author.setId(set.getInt("id"));
            author.setFirstName(set.getString("first_name"));
            author.setLastName(set.getString("last_name"));
            author.setPatronymic(set.getString("patronymic"));
            author.setBiography(set.getString("biography"));
            return author;
        });
        return new ArrayList<>(authors);
    }

    public List<Author> getAuthorsByStartSymbol(String symbol) {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors WHERE first_name LIKE '" + symbol + "%';", (ResultSet set, int e) -> {
            var author = new Author();
            author.setId(set.getInt("id"));
            author.setFirstName(set.getString("first_name"));
            author.setLastName(set.getString("last_name"));
            author.setPatronymic(set.getString("patronymic"));
            author.setBiography(set.getString("biography"));
            return author;
        });
        return new ArrayList<>(authors);
    }

    public List<Author> getAuthorsByBookId(Integer bookId) {
        List<Author> authors = jdbcTemplate.query("select * from authors where id in (SELECT author_id from books where id="+bookId+");", (ResultSet rs, int rownum) -> {
            var author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            author.setPatronymic(rs.getString("patronymic"));
            author.setBiography(rs.getString("biography"));
            return author;
        });
        return new ArrayList<>(authors);
    }

    public List<String> getAuthorsFirstLetters() {
        return jdbcTemplate.query("SELECT DISTINCT SUBSTRING (first_name, 1, 1)  as letter FROM AUTHORS ", (ResultSet rs, int rownum) -> {
            return rs.getString("letter");
        });
    }
}
