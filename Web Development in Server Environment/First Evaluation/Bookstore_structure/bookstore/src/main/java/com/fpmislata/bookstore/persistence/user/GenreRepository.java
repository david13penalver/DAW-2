package com.fpmislata.bookstore.persistence.user;

import com.fpmislata.bookstore.domain.user.model.Genre;

import java.util.List;

public interface GenreRepository {
    List<Genre> getByIsbnBook(String isbn);

    List<Genre> getAll();
}
