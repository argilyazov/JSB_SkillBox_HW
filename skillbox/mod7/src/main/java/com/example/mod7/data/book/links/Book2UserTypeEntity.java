package com.example.mod7.data.book.links;

import com.example.mod7.data.enums.B2UType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book2user_type")
public class Book2UserTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ElementCollection(targetClass = B2UType.class, fetch = FetchType.EAGER)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public B2UType getCode() {
        return code;
    }

    public void setCode(B2UType code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
