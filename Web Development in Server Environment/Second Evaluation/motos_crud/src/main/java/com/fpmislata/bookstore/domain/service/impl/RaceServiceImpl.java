package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.model.Race;
import com.fpmislata.bookstore.domain.repository.RaceRepository;
import com.fpmislata.bookstore.domain.service.RaceService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;

    @Override
    public ListWithCount<Race> getAll(int page, int pageSize) {
        return raceRepository.getAll(page, pageSize);
    }

    @Override
    public Optional<Race> findById(Long id) {
        return raceRepository.findById(id);
    }

    @Override
    public void insert(Race race) {
        raceRepository.insert(race);
    }
}
