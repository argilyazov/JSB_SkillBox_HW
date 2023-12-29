package com.example.mod7.data.book;

import com.example.mod7.data.user.UserEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book_rating")
@Data
public class BookRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Book book;
    @OneToOne
    private UserEntity user;
    @Column(name = "rating", nullable = false)
    private short rating;

}
