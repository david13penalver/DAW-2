package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    Optional<Book> findByIsbn(String isbn);
}
