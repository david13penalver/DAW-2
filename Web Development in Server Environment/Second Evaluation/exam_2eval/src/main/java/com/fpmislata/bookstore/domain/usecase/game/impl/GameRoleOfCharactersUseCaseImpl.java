package com.fpmislata.bookstore.domain.usecase.game.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.model.Figure;
import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.domain.service.FigureService;
import com.fpmislata.bookstore.domain.service.GameService;
import com.fpmislata.bookstore.domain.usecase.game.GameRoleOfCharactersUseCase;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class GameRoleOfCharactersUseCaseImpl implements GameRoleOfCharactersUseCase {

    private final GameService gameService;
    private final FigureService figureService;

    @Override
    public Game execute(String gameCode, String rol) {
        Game game = gameService.findByGameCode(gameCode)
                .orElseThrow(() -> new RuntimeException("Game not found"));

        List<Figure> figuresWithRoleNumber = figureService.findAllById(game.getFigures());
        List<Figure> figuresWithRole = new ArrayList<>();

        figuresWithRoleNumber.forEach(figure -> {
            if(figure.getRole().equals("Personaje principal")) {
                figure.setRole("1");
            } else if(figure.getRole().equals("Antagonista")) {
                figure.setRole("2");
            } else {
                figure.setRole("3");
            }
        });

        figuresWithRoleNumber.forEach(figure -> {
                    if (figure.getRole().equals(rol)) {
                        figuresWithRole.add(figure);
                    }
                }
        );

        game.setFigures(figuresWithRole);

        return game;
    }
}
