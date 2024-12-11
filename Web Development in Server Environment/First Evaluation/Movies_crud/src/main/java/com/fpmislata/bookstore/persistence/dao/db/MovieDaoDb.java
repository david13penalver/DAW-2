package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.Movie;

import java.util.Collection;
import java.util.List;

public interface MovieDaoDb {
    List<Movie> getAll(Integer page, Integer size);
}
