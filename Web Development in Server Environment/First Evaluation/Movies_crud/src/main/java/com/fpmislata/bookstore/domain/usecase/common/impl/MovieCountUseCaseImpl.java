package com.fpmislata.bookstore.domain.usecase.common.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.service.MovieService;
import com.fpmislata.bookstore.domain.usecase.common.MovieCountUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieCountUseCaseImpl implements MovieCountUseCase {

    private final MovieService movieService;

    @Override
    public Integer execute() {
        return movieService.count();
    }
}
