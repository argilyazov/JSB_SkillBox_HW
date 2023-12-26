package com.example.sbhw.domain;

import org.springframework.stereotype.Component;


public interface Library {
    public void getBook();
    public void returnBook();
    public void addAuthor(String author);
}
