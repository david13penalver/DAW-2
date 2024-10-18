package com.fpmislata.bookstore.domain.user.service;

import com.fpmislata.bookstore.domain.user.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book findByIsbn(String isbn);

    List<Book> getAll(int page, int size);

    int count();
}
