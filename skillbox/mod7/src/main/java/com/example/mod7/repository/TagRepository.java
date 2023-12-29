package com.example.mod7.repository;

import com.example.mod7.data.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findBySlug(String slug);

}
