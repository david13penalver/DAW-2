package com.fpmislata.bookstore.persistence;

import com.fpmislata.bookstore.domain.model.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> getByIsbnBook(String isbn);
}
