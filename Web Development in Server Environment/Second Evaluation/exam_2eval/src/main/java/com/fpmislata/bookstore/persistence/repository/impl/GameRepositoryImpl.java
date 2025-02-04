package com.fpmislata.bookstore.persistence.repository.impl;

import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.repository.GameRepository;
import com.fpmislata.bookstore.persistence.dao.db.GameDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GameRepositoryImpl implements GameRepository {

    private final GameDaoDb gameDaoDb;

    @Override
    public ListWithCount<Game> getAll(int page, int pageSize) {
        return gameDaoDb.getAll(page, pageSize);
    }

    @Override
    public Optional<Game> findByGameCode(String gameCode) {
        return gameDaoDb.findByGameCode(gameCode);
    }

    @Override
    public void save(Game game) {
        gameDaoDb.save(game);
    }
}
