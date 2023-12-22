package com.example.mod2.domain;

import java.util.List;

public interface Library {

    public void getBook(Book book);
    public void returnBook(Book book);
    public void addAuthor(String authors);
    public List<String> getAuthors();
}
