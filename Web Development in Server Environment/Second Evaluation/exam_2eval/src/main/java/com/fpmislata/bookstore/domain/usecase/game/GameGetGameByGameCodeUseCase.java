package com.fpmislata.bookstore.domain.usecase.game;

import com.fpmislata.bookstore.domain.model.Game;

import java.util.Optional;

public interface GameGetGameByGameCodeUseCase {
    Game execute(String gameCode);
}
