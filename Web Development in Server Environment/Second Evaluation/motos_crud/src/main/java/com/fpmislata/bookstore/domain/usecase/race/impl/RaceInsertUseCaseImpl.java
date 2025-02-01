package com.fpmislata.bookstore.domain.usecase.race.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.model.Race;
import com.fpmislata.bookstore.domain.service.RaceService;
import com.fpmislata.bookstore.domain.usecase.race.RaceInsertUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class RaceInsertUseCaseImpl implements RaceInsertUseCase {

    private final RaceService raceService;

    @Override
    public void execute(Race race) {
        raceService.insert(race);
    }
}
