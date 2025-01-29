package com.fpmislata.bookstore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;
    private String isbn;
    private String title;
    private String synopsis;
    private Long price;
    private Long discount;
    private String cover;
    private List<Author> authors;
    private List<Genre> genres;
    private Category category;
    private Publisher publisher;
}
