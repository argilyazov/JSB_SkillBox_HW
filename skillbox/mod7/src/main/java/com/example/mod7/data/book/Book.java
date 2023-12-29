package com.example.mod7.data.book;

import com.example.mod7.data.author.Author;
import com.example.mod7.data.book.links.*;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    @Column(columnDefinition = "VARCHAR(255)",unique = true)
    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "INT NOT NULL")
    private Integer price;
    @Column(columnDefinition = "SMALLINT NOT NULL DEFAULT 0")
    private short discount;

    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<Book2UserEntity> book2UserEntitySet;

    @JsonManagedReference
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<Book2AuthorEntity> book2AuthorEntities;

    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<Book2GenreEntity> book2GenreEntities;
    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<Book2Tag> book2Tags;

//    B — количество пользователей, купивших книгу,
//    C — количество пользователей, у которых книга находится в корзине, а
//    K — количество пользователей, у которых книга отложена.

    @Column(columnDefinition = "integer default 0")
    private int statB;
    @Column(columnDefinition = "integer default 0")
    private int statC;
    @Column(columnDefinition = "integer default 0")
    private int statK;
    @Column(columnDefinition = "Decimal(10,5) default '0'")
    private double statP;


    @JsonProperty("discountPrice")
    public int getDiscountPrice() {
        return price-price*discount/100;
    }

    @JsonGetter("authors")
    public List<Author> getAuthors() {
        var authors = new ArrayList<Author>();
        for (var b2a : this.book2AuthorEntities) {
            authors.add(b2a.getAuthor());
        }
        return authors;
    }


}

