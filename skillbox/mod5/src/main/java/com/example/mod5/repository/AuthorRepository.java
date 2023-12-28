package com.example.mod5.repository;

import com.example.mod5.data.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
