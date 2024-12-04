package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.domain.repository.GenreRepository;
import com.fpmislata.bookstore.domain.service.GenreService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<Genre> findAllById(List<Genre> genres) {
        return genreRepository.findAllById(genres);
    }
}
