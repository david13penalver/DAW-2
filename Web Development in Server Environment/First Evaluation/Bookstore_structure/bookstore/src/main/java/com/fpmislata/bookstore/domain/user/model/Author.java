package com.fpmislata.bookstore.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private long id;
    private String name;
    private String nationality;
    private String biography;
    private int birthYear;
    private int deathYear;
}
