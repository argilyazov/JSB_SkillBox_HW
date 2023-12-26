package com.example.mod3.data;

import lombok.Data;

import javax.persistence.Column;

@Data
public class Book {

    private Integer id;

    @Column(name = "author_id")
    private Integer authorId;
    private String title;
    @Column(name = "price_old")
    private Integer priceOld;
    private Integer price;

}
