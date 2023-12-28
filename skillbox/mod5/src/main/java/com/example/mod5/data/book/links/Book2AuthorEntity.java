package com.example.mod5.data.book.links;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book2author")
@Data
public class Book2AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "INT NOT NULL")
    private int bookId;

    @Column(columnDefinition = "INT NOT NULL")
    private int authorId;

    @Column(columnDefinition = "INT NOT NULL  DEFAULT 0")
    private int sortIndex;

}
