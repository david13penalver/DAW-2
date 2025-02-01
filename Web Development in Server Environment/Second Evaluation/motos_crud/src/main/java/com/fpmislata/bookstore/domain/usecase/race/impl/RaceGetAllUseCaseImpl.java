package com.fpmislata.bookstore.domain.usecase.race.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.model.Race;
import com.fpmislata.bookstore.domain.service.RaceService;
import com.fpmislata.bookstore.domain.usecase.RaceGetAllUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class RaceGetAllUseCaseImpl implements RaceGetAllUseCase {

    private final RaceService raceService;
    @Override
    public ListWithCount<Race> execute(int page, int pageSize) {
        return raceService.getAll(page, pageSize);
    }
}
