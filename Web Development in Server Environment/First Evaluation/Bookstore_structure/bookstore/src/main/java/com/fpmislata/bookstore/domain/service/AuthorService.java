package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAll();

    Optional<Author> findById(int id);

    List<Book> getBooksByAuthor(int id);
}
