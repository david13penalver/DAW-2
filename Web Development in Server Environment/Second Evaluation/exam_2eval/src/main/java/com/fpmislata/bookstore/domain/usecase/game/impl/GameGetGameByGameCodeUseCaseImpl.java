package com.fpmislata.bookstore.domain.usecase.game.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.domain.service.GameService;
import com.fpmislata.bookstore.domain.usecase.game.GameGetGameByGameCodeUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class GameGetGameByGameCodeUseCaseImpl implements GameGetGameByGameCodeUseCase {

    private final GameService gameService;

    @Override
    public Game execute(String gameCode) {
        return gameService.findByGameCode(gameCode)
                .orElseThrow(() -> new RuntimeException("Game not found"));
    }
}
