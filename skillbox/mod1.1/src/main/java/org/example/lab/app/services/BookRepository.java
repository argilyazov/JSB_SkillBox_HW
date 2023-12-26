package org.example.lab.app.services;

import org.apache.log4j.Logger;
import org.example.lab.web.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements ProjectRepository<Book> {

    private final List<Book> repo = new ArrayList<>();

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
       repo.add(book);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        for (Book book : retreiveAll()) {
            if (book.getId().equals(bookIdToRemove)) {
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeItemByRegex(String queryRegex) {

        var regexParts = queryRegex.toLowerCase().split("=");
        if (regexParts.length == 2) {
            var type = regexParts[0];
            var value = regexParts[1];

            if (type.equals("author") || type.equals("title") || type.equals("size")) {
                for (Book book : retreiveAll()) {

                    if (type.equals("author") && book.getAuthor().equals(value)) {
                        return repo.remove(book);
                    }
                    if (type.equals("title") && book.getTitle().equals(value)) {
                        return repo.remove(book);
                    }
                    try {
                        if (type.equals("size") && book.getSize() == Integer.parseInt(value)) {
                            return repo.remove(book);
                        }
                    } catch (Exception e) {
                    }

                }
            }
        }

        return false;
    }
}
