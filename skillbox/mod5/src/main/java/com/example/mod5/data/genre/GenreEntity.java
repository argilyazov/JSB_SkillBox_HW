package com.example.mod5.data.genre;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "genre")
@Data
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "INT")
    private int parentId;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String slug;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

}
