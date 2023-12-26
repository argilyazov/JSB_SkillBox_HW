package com.example.mod3.data;

import lombok.Data;

import javax.persistence.Column;

@Data
public class Author {
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String patronymic;
    private String biography;

    public String getFullName() {
        return String.format("%s %s %s", firstName, lastName, patronymic);
    }
}
