package com.example.mod7.data.genre;

import com.example.mod7.data.book.links.Book2GenreEntity;
import com.example.mod7.data.book.links.Book2UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre")
@Data
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "INT")
    private Integer parentId;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String slug;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
    private Set<Book2GenreEntity> book2GenreEntities;

}
