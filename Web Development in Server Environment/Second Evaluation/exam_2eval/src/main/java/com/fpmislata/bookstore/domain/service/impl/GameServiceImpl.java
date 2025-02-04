package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.repository.GameRepository;
import com.fpmislata.bookstore.domain.service.GameService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public ListWithCount<Game> getAll(int page, int pageSize) {
        return gameRepository.getAll(page, pageSize);
    }

    @Override
    public Optional<Game> findByGameCode(String gameCode) {
        return gameRepository.findByGameCode(gameCode);
    }

    @Override
    public void save(Game game) {
        gameRepository.save(game);
    }
}
