package com.fpmislata.bookstore.domain.usecase.common;

import com.fpmislata.bookstore.domain.model.Movie;

import java.util.Collection;
import java.util.List;

public interface MovieGetAllUseCase {
    List<Movie> execute(Integer page, Integer size);
}
