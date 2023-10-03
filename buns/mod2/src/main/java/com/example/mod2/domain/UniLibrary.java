package com.example.mod2.domain;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class UniLibrary implements Library{
    private List<String> authors = new ArrayList<>();
    @Override
    public void getBook() {
        System.out.println("Взяли книгу");
    }

    @Override
    public void returnBook() {
        System.out.println("Вернули книгу");
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
