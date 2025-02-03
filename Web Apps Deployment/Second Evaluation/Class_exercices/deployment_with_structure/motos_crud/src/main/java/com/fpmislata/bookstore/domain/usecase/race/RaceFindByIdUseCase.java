package com.fpmislata.bookstore.domain.usecase.race;

import com.fpmislata.bookstore.domain.model.Race;

public interface RaceFindByIdUseCase {
    Race execute(Long id);
}
