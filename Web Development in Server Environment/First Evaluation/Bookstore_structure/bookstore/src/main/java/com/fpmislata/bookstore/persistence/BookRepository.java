package com.fpmislata.bookstore.persistence;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Genre;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> getAll();

    Optional<Book> findByIsbn(String isbn);

    List<Book> getBooksByAuthor(int id);

    List<Book> getBooksByGenre(int id);

    int count();

    List<Book> getAll(int page, int size);
}
