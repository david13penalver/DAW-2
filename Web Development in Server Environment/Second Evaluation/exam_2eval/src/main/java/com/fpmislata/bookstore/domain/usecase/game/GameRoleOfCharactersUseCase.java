package com.fpmislata.bookstore.domain.usecase.game;

import com.fpmislata.bookstore.domain.model.Game;

public interface GameRoleOfCharactersUseCase {

    Game execute(String gameCode, String rol);
}
