package com.fpmislata.bookstore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {


    private String gameCode;
    private String title;
    private Long releaseYear;
    private String description;
    private Director director;
    private List<Figure> figures;
}
