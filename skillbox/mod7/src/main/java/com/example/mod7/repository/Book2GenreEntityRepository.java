package com.example.mod7.repository;

import com.example.mod7.data.book.Book;
import com.example.mod7.data.book.links.Book2GenreEntity;
import com.example.mod7.data.genre.GenreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Book2GenreEntityRepository extends JpaRepository<Book2GenreEntity,Long> {

    Page<Book2GenreEntity> findAllBookByGenre(GenreEntity genre, Pageable nextPage);
}
