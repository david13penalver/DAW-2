package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.ListWithCount;

import java.util.Optional;

public interface BookService {
    ListWithCount<Book> getAll(int page, int pageSize);

    Optional<Book> findByIsbn(String isbn);

    void save(Book book);

    Optional<Book> findById(Long id);

    void delete(Long id);

    ListWithCount<Book> getAllBooksByAuthor(Long id, int page, int pageSize);
}
