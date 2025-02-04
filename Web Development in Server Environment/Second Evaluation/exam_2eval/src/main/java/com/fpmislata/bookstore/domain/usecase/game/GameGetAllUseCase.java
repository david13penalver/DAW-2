package com.fpmislata.bookstore.domain.usecase.game;

import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.domain.model.ListWithCount;

public interface GameGetAllUseCase {
    ListWithCount<Game> execute(int page, int pageSize);
}
