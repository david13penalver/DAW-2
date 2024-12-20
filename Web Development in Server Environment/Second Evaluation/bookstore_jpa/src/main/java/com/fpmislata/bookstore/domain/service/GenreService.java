package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getByIdBook(long idBook);

    List<Genre> findAllById(List<Genre> genres);
}
