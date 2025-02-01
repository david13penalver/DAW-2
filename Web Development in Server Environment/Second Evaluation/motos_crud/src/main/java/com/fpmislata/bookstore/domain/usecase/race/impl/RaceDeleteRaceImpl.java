package com.fpmislata.bookstore.domain.usecase.race.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.service.RaceService;
import com.fpmislata.bookstore.domain.usecase.race.RaceDeleteRace;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class RaceDeleteRaceImpl implements RaceDeleteRace {

    private final RaceService raceService;

    @Override
    public void execute(Long id) {
        raceService.delete(id);
    }
}
