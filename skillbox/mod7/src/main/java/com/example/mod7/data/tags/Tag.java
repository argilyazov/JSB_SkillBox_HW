package com.example.mod7.data.tags;

import com.example.mod7.data.book.links.Book2Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag")
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;

    @JsonIgnore
    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private Set<Book2Tag> book2Tags;
}
