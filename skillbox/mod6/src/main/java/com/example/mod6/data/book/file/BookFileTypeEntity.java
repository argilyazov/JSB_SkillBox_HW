package com.example.mod6.data.book.file;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book_file_type")
@Data
public class BookFileTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

}
