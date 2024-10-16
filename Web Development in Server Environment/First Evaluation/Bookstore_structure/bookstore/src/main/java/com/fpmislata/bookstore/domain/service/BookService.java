package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    Book findByIsbn(String isbn);

    List<Book> getAll(int page, int size);

    int count();
}
