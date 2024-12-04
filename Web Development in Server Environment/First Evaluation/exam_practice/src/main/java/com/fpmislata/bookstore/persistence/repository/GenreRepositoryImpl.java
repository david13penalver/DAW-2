package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.domain.repository.GenreRepository;
import com.fpmislata.bookstore.persistence.dao.db.GenreDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreRepositoryImpl implements GenreRepository {

    private final GenreDaoDb genreDaoDb;

    @Override
    public List<Genre> findAllById(List<Genre> genres) {
        return genreDaoDb.findAllById(genres);
    }
}
