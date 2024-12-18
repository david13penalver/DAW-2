package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Movie;
import com.fpmislata.bookstore.domain.repository.MovieRepository;
import com.fpmislata.bookstore.persistence.dao.db.MovieDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {

    private final MovieDaoDb movieDaoDb;

    @Override
    public List<Movie> getAll(Integer page, Integer size) {
        return movieDaoDb.getAll(page, size);
    }

    @Override
    public Integer count() {
        return movieDaoDb.count();
    }
}
