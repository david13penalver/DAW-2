package com.fpmislata.bookstore.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    @Column(name = "biography_en")
    private String biographyEn;
    @Column(name = "biography_es")
    private String biographyEs;
    @Column(name = "birth_year")
    private int birthYear;
    @Column(name = "death_year")
    private int deathYear;
}
