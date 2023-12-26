package com.example.sbhw.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("uniLibrary")
@Getter
public class UniLibrary implements Library {
    List<String> authors = new ArrayList<>();

    @Override
    public void getBook() {
        System.out.println("Взял книгу");
    }

    @Override
    public void returnBook() {
        System.out.println("Вернул книгу");
    }

    @Override
    public void addAuthor(String author) {
        authors.add(author);
        System.out.println("Добавил автора " + author);
    }
}
