package com.example.mod7.service;

import com.example.mod7.data.author.Author;
import com.example.mod7.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;



    public Map<String, List<Author>> getAuthorsMap() {
        var authors = authorRepository.findAll();

        return authors.stream().collect(Collectors.groupingBy((Author a) -> {
            return a.getName().substring(0, 1);
        }));
    }

    public Author getAuthorBySlug(String slug) {
        return authorRepository.findBySlug(slug);
    }
}
