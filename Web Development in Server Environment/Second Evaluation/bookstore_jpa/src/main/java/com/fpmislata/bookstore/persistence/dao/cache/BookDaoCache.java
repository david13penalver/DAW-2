package com.fpmislata.bookstore.persistence.dao.cache;

import com.fpmislata.bookstore.domain.model.Book;

import java.util.Optional;

public interface BookDaoCache extends GenericDaoCache<Book>{

    Optional<Book> findByIsbn(String isbn);
}
