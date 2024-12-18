package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Movie;
import com.fpmislata.bookstore.domain.repository.MovieRepository;
import com.fpmislata.bookstore.domain.service.MovieService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getAll(Integer page, Integer size) {
        return movieRepository.getAll(page, size);
    }

    @Override
    public Integer count() {
        return movieRepository.count();
    }
}
