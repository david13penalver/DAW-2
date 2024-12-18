package com.fpmislata.bookstore.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
public class Movie {
    private String id;
    private String title;
    private Integer year;
    private String image;
    private Director director;
    private List<Actor> actors;

    public Movie() {
    }

    public Movie(String id, String title, Integer year, String image, Director director, List<Actor> actors) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.image = image;
        this.director = director;
        this.actors = actors;
    }
}