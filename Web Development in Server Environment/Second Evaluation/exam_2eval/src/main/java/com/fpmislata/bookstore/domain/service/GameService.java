package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.domain.model.ListWithCount;

import java.util.Optional;

public interface GameService {
    ListWithCount<Game> getAll(int page, int pageSize);

    Optional<Game> findByGameCode(String gameCode);

    void save(Game game);
}
