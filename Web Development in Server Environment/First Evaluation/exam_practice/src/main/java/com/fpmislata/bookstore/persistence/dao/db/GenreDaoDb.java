package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.Genre;

import java.util.List;

public interface GenreDaoDb extends GenericDaoDb<Genre> {

    List<Genre> getByIdBook(long idBook);
    List<Genre> findAllById(List<Genre> genres);
    List<Genre> getByIsbnBook(String isbn);
}
