package com.example.mod5.data.user;

import com.example.mod5.data.enums.ContactType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_contact")
public class UserContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "INT NOT NULL")
    private int userId;

    private ContactType type;

    @Column(columnDefinition = "SMALLINT NOT NULL")
    private short approved;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String code;

    @Column(columnDefinition = "INT")
    private int codeTrails;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime codeTime;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String contact;

}
