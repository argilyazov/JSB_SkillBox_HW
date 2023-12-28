package com.example.mod5.data.book.links;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "book2user")
@Data
public class Book2UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime time;

    @Column(columnDefinition = "INT NOT NULL")
    private int typeId;

    @Column(columnDefinition = "INT NOT NULL")
    private int bookId;

    @Column(columnDefinition = "INT NOT NULL")
    private int userId;

}
