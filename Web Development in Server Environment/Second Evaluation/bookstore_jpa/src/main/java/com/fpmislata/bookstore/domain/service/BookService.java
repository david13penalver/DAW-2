package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.domain.model.ListWithCount;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAll();

    ListWithCount<Book> getAll(int page, int size);

    long count();

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findById(long id);

    void save(Book book);

    void addAuthor(Book book, Author author);

    void addGenre(Book book, Genre genre);

    void delete(long id);
}
