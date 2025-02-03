package com.fpmislata.bookstore.domain.usecase.race.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Race;
import com.fpmislata.bookstore.domain.service.RaceService;
import com.fpmislata.bookstore.domain.usecase.race.RaceFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class RaceFindByIdUseCaseImpl implements RaceFindByIdUseCase {

    private final RaceService raceService;

    @Override
    public Race execute(Long id) {
        return raceService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Race with id " + id + " not found"));
    }
}
