package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.Game;

import java.util.Optional;

public interface GameDaoDb extends GenericDaoDb<Game> {
    Optional<Game> findByGameCode(String gameCode);
}
