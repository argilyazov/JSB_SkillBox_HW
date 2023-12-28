package com.example.mod5.data.book;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "DATE NOT NULL", name = "pub_date")
    private Date pubDate;

    @Column(columnDefinition = "SMALLINT NOT NULL", name = "is_bestseller")
    private short isBestseller;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String slug;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String title;
    @Column(columnDefinition = "VARCHAR(255)")
    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "INT NOT NULL")
    private Integer price;
    @Column(columnDefinition = "SMALLINT NOT NULL DEFAULT 0")
    private short discount;

}

