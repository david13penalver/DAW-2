package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Movie;

import java.util.Collection;
import java.util.List;

public interface MovieService {
    List<Movie> getAll(Integer page, Integer size);

    Integer count();
}
