package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> getAll(int i, int pageSize);

    int count();

    Optional<Book> findByIsbn(String isbn);

    void save(Book book);
}
