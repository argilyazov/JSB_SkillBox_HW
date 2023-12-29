package com.example.mod7.repository;

import com.example.mod7.data.book.Book;
import com.example.mod7.data.book.links.Book2Tag;
import com.example.mod7.data.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Book2TagRepository extends JpaRepository<Book2Tag,Long> {
    Long countByTag(Tag tag);

    Page<Book2Tag> findByTag(Tag tag, Pageable nextPage);

}
