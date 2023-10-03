package com.example.mod2.domain;

import java.util.List;

public interface Library {
    public void getBook();
    public void returnBook();
    public void addAuthor(String authors);
    public List<String> getAuthors();
}
