package com.example.mod6.repository;

import com.example.mod6.data.author.Author;
import com.example.mod6.data.book.links.Book2AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book2AuthorEntityRepository extends JpaRepository<Book2AuthorEntity,Integer> {
    Page<Book2AuthorEntity> findAllByAuthor(Author author, Pageable nextPage);
    Page<Book2AuthorEntity> findAllByAuthorOrderByBookPubDate(Author author, Pageable nextPage);

    int countByAuthor(Author author);
}
