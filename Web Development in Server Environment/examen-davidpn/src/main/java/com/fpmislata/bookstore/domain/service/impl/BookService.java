package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Order;

import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Long idBook);
}
