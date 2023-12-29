package com.example.mod6.data.book.links;


import com.example.mod6.data.enums.B2UType;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "book2user_type")
@Data
public class Book2UserTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private B2UType code;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Book2UserEntity> book2UserEntitySet;

    public Set<Book2UserEntity> getBook2UserEntitySet() {
        return book2UserEntitySet;
    }

    public void setBook2UserEntitySet(Set<Book2UserEntity> book2UserEntitySet) {
        this.book2UserEntitySet = book2UserEntitySet;
    }

}
