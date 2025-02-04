package com.fpmislata.bookstore.domain.usecase.game.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.service.GameService;
import com.fpmislata.bookstore.domain.usecase.game.GameGetAllUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class GameGetAllUseCaseImpl implements GameGetAllUseCase {

    private final GameService gameService;

    @Override
    public ListWithCount<Game> execute(int page, int pageSize) {
        return gameService.getAll(page, pageSize);
    }
}
