package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.Author;

import java.util.List;

public interface AuthorDaoDb extends GenericDaoDb<Author> {

    List<Author> getByIsbnBook(String isbn);
    List<Author> getByIdBook(long idBook);
    List<Author> findAllById(Long[] ids);
}
