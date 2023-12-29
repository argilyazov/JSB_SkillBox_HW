package com.example.mod7.data.book;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book_file")
@Data
public class BookFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String hash;

    @Column(columnDefinition = "INT NOT NULL",name = "type_id")
    private int typeId;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String path;


}
