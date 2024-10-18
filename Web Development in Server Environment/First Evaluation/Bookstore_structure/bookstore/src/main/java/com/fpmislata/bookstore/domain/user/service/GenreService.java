package com.fpmislata.bookstore.domain.user.service;

import com.fpmislata.bookstore.domain.user.model.Book;
import com.fpmislata.bookstore.domain.user.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();

    List<Book> getBooksByGenre(int id);
}
