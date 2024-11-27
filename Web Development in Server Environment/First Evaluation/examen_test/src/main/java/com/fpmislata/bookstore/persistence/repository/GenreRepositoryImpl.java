package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.domain.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class GenreRepositoryImpl implements GenreRepository {

    private final GenreDaoDb genreDaoDb;

    @Override
    public List<Genre> getByIdBook(long idBook) {
        return genreDaoDb.getByIdBook(idBook);
    }

    @Override
    public List<Genre> findAllById(List<Genre> genres) {
        return genreDaoDb.findAllById(List<Genre> genres);
    }
}
