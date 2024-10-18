package com.fpmislata.bookstore.domain.user.service;

import com.fpmislata.bookstore.domain.user.model.Author;
import com.fpmislata.bookstore.domain.user.model.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAll();

    Optional<Author> findById(int id);

    List<Book> getBooksByAuthor(int id);
}
