package com.fpmislata.bookstore.persistence.repository.impl;

import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.model.Race;
import com.fpmislata.bookstore.domain.repository.RaceRepository;
import com.fpmislata.bookstore.persistence.dao.db.RaceDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RaceRepositoryImpl implements RaceRepository {

    private final RaceDao raceDao;

    @Override
    public ListWithCount<Race> getAll(int page, int pageSize) {
        return raceDao.getAll(page, pageSize);
    }

    @Override
    public Optional<Race> findById(Long id) {
        return raceDao.findById(id);
    }

    @Override
    public void insert(Race race) {
        raceDao.insert(race);
    }
}
