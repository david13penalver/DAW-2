package com.fpmislata.bookstore.domain.usecase.common.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.model.Movie;
import com.fpmislata.bookstore.domain.service.MovieService;
import com.fpmislata.bookstore.domain.usecase.common.MovieGetAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieGetAllUseCaseImpl implements MovieGetAllUseCase {

    private static MovieService movieService;

    @Override
    public List<Movie> execute(Integer page, Integer size) {
        return movieService.getAll(page, size);
    }
}
