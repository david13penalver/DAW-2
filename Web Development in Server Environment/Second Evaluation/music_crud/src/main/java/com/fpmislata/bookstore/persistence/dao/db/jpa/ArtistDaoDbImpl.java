package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.Album;
import com.fpmislata.bookstore.domain.model.Artist;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.persistence.dao.db.AlbumDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.ArtistDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.ArtistJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ArtistDaoDbImpl implements ArtistDaoDb {

    private final ArtistJPARepository artistJPARepository;


    @Override
    public List<Artist> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Artist> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Artist> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Artist artist) {
        return 0;
    }

    @Override
    public void update(Artist artist) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Artist save(Artist artist) {
        return null;
    }
}
