package com.example.mod5.data.book.file;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book_file_type")
public class BookFileTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

}
