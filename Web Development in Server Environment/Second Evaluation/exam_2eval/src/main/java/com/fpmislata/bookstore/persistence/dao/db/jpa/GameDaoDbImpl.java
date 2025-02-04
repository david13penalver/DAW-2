package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.persistence.dao.db.GameDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.GameJPA;
import com.fpmislata.bookstore.persistence.dao.db.jpa.mapper.GameJPAMapper;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.GameJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GameDaoDbImpl implements GameDaoDb {

    private final GameJPARepository gameJPARepository;

    @Override
    public List<Game> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Game> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<GameJPA> gameJPAPage = gameJPARepository.findAll(pageable);
        return new ListWithCount<>(
                gameJPAPage.stream()
                        .map(GameJPAMapper.INSTANCE::toGame)
                        .toList(),
                gameJPAPage.getTotalElements()
        );
    }

    @Override
    public Optional<Game> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Game game) {
        return 0;
    }

    @Override
    public void update(Game game) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Game save(Game game) {
        GameJPA gameJPA = GameJPAMapper.INSTANCE.toGameJPA(game);
        return GameJPAMapper.INSTANCE.toGame(gameJPARepository.save(gameJPA));
    }

    @Override
    public Optional<Game> findByGameCode(String gameCode) {
        return Optional.ofNullable(gameJPARepository.findByGameCode(gameCode))
                .map(GameJPAMapper.INSTANCE::toGame);
    }
}
