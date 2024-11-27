package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Genre;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAll(int page, int size);

    int count();

    Optional<Book> findByIsbn(String isbn);

    void addAuthor(Book book, Author author);

    void addGenre(Book book, Genre genre);

    void save(Book book);
}
