package com.example.mod6.repository;

import com.example.mod6.data.genre.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreEntityRepository extends JpaRepository<GenreEntity,Long> {

    List<GenreEntity> findByParentId(Integer id);
    GenreEntity findBySlug(String slug);

}
