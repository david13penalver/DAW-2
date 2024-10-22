package com.fpmislata.bookstore.domain.admin.service;

import com.fpmislata.bookstore.domain.admin.model.Book;

import java.util.List;

public interface BookAdminService {
    List<Book> getAll();

    List<Book> getAll(int page, int size);

    int count();

    Book findByIsbn(String isbn);
}
