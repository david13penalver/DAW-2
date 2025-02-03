package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.model.Song;
import com.fpmislata.bookstore.persistence.dao.db.SongDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.SongJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SongDaoDbImpl implements SongDaoDb {

    private final SongJPARepository songJPARepository;

    @Override
    public List<Song> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Song> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Song> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Song song) {
        return 0;
    }

    @Override
    public void update(Song song) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Song save(Song song) {
        return null;
    }
}
