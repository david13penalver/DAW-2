package com.fpmislata.bookstore.domain.usecase;

import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.model.Race;

public interface RaceGetAllUseCase {
    ListWithCount<Race> execute(int page, int pageSize);
}
