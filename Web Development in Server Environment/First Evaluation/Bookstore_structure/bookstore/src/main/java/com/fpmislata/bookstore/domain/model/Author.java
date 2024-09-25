package com.fpmislata.bookstore.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//@NoArgsConstructor
//@RequiredArgsConstructor
public class Author {

    private long id;
    private String name;
    private String nationality;
    private String biography;
    private int birthYear;
    private int deathYear;
}
