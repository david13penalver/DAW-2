package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "biography_es")
    private String biography;
    @Column(name = "birth_year")
    private Integer birthYear;
    @Column(name = "death_year")
    private Integer deathYear;
}
