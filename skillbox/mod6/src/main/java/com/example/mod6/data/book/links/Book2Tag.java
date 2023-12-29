package com.example.mod6.data.book.links;

import com.example.mod6.data.book.Book;
import com.example.mod6.data.tags.Tag;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book2tag")
@Data
public class Book2Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tag_id")
    private Tag tag;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

}
