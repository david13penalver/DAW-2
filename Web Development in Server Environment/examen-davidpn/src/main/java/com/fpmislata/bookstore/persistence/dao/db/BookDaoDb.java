package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Order;

import java.util.Optional;

public interface BookDaoDb {
    Optional<Book> findById(Long idBook);
}
