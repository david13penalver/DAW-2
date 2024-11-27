package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> getAll(int page, int size);

    int count();

    Optional<Book> findByIsbn(String isbn);

    void save(Book book);
}
