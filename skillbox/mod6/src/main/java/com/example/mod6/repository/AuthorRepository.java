package com.example.mod6.repository;

import com.example.mod6.data.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    Author findBySlug(String slug);

}
