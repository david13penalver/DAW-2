package com.fpmislata.bookstore.persistence;

import com.fpmislata.bookstore.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> getAll();

    Optional<Book> findByIsbn(String isbn);

    List<Book> getBooksByAuthor(int id);
}
