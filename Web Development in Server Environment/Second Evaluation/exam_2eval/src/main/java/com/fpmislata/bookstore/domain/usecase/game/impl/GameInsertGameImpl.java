package com.fpmislata.bookstore.domain.usecase.game.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.common.exception.ResourceAlreadyExistsException;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.domain.service.DirectorService;
import com.fpmislata.bookstore.domain.service.FigureService;
import com.fpmislata.bookstore.domain.service.GameService;
import com.fpmislata.bookstore.domain.usecase.game.GameInsertGame;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class GameInsertGameImpl implements GameInsertGame {

    private final GameService gameService;
    private final DirectorService directorService;
    private final FigureService figureService;

    @Override
    public void execute(Game game) {
        if(gameService.findByGameCode(game.getGameCode()).isPresent()) {
            throw new ResourceAlreadyExistsException("Game with game code " + game.getGameCode() + " already exists");
        }

        game.setDirector(
                directorService
                        .findById(game.getDirector().getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Director not found"))
        );

        game.setFigures(
                figureService
                        .findAllById(game.getFigures())
        );

        gameService.save(game);

    }
}
