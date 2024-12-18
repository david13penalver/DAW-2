package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Movie;

import java.util.Collection;
import java.util.List;

public interface MovieRepository {
    List<Movie> getAll(Integer page, Integer size);

    Integer count();
}
