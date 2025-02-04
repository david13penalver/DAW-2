package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.domain.model.ListWithCount;

import java.util.Optional;

public interface GameRepository {
    ListWithCount<Game> getAll(int page, int pageSize);

    Optional<Game> findByGameCode(String gameCode);

    void save(Game game);
}
