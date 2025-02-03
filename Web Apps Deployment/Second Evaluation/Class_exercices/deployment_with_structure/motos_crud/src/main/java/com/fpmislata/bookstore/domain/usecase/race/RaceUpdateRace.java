package com.fpmislata.bookstore.domain.usecase.race;

import com.fpmislata.bookstore.domain.model.Race;

public interface RaceUpdateRace {
    void execute(Long id, Race race);
}
