package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Order;

import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(Long idBook);
}
