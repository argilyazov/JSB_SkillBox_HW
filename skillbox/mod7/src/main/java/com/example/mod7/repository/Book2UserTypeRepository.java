package com.example.mod7.repository;

import com.example.mod7.data.book.links.Book2UserTypeEntity;
import com.example.mod7.data.enums.B2UType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book2UserTypeRepository extends JpaRepository<Book2UserTypeEntity,Integer> {

    Book2UserTypeEntity findByCode(B2UType code);

}
