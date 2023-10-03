package com.example.mod2.domain;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class UniLibrary implements Library{
    private List<String> authors = new ArrayList<>();
    @Override
    public void getBook(Book book) {
        System.out.println("Взяли книгу"+book);
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("Вернули книгу"+book);
    }

    @Override
    public void addAuthor(String author) {
        if (authors.contains(author)) throw new RuntimeException(String.format("Автор %s уже есть в библиотеке",author));
        authors.add(author);
    }

    public List<String> getAuthors() {
        return authors;
    }
}
