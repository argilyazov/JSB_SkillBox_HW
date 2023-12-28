package com.example.mod5.data.author;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(255)")
    private String photo;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String slug;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;

}
