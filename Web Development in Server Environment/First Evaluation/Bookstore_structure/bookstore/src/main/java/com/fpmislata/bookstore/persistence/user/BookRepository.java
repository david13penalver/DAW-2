package com.fpmislata.bookstore.persistence.user;

import com.fpmislata.bookstore.domain.user.model.Book;

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
