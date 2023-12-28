package com.example.mod5.service;

import com.example.mod5.data.author.Author;
import com.example.mod5.repository.AuthorRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Map<String, List<Author>> getAuthorsMap(){
        var authors = authorRepository.findAll();

        return authors.stream().collect(Collectors.groupingBy((Author a)->{return a.getName().substring(0,1);}));
    }
}
