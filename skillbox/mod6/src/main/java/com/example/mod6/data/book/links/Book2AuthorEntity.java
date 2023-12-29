package com.example.mod6.data.book.links;

import com.example.mod6.data.author.Author;
import com.example.mod6.data.book.Book;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book2author")
@Data
public class Book2AuthorEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @JsonIgnore
    @Column(columnDefinition = "INT NOT NULL  DEFAULT 0")
    private int sortIndex;


}
