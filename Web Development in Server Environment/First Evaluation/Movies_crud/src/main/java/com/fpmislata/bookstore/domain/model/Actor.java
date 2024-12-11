package com.fpmislata.bookstore.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Actor {
    private Integer id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
}
