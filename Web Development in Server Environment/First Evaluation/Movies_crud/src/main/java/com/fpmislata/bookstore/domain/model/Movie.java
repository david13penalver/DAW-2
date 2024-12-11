package com.fpmislata.bookstore.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Movie {
    private Integer id;
    private String title;
    private Integer year;
    private String image;
    private Director director;
    private List<Actor> actors;
}
