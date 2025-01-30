package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.Book;

import java.util.Optional;

public interface BookDaoJpa extends GenericDaoDb<Book> {
    Optional<Book> findByIsbn(String isbn);
}
