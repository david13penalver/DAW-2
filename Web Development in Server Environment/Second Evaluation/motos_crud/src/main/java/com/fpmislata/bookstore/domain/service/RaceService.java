package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.model.Race;

import java.util.Optional;

public interface RaceService {
    ListWithCount<Race> getAll(int page, int pageSize);

    Optional<Race> findById(Long id);

    void insert(Race race);

    void delete(Long id);
}
