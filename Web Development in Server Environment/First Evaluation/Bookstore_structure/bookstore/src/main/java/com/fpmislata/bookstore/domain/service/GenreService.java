package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();

    List<Book> getBooksByGenre(int id);
}
