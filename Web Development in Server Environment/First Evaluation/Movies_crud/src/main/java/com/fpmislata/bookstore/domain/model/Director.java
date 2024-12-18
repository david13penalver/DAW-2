package com.fpmislata.bookstore.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.swing.*;

@Data
//@NoArgsConstructor
//@RequiredArgsConstructor
public class Director {
    private String id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;

    public Director() {
    }

    public Director(String id, String name, Integer birthYear, Integer deathYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }
}
