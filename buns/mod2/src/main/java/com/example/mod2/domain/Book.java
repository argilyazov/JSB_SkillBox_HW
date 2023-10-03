package com.example.mod2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Getter
@AllArgsConstructor
public class Book {

    String title;

    String author;

    @Override
    public String toString() {
        return " Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
