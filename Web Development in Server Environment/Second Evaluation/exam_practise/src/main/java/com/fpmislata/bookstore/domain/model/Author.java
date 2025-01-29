package com.fpmislata.bookstore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private Long id;
    private String name;
    private String nationality;
    private String biography;
    private Integer birthYear;
    private Integer deathYear;
}
