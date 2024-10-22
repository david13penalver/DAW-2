package com.fpmislata.bookstore.persistence.admin;

import com.fpmislata.bookstore.domain.admin.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookAdminRepository {
    List<Book> getAll();

    List<Book> getAll(int page, int size);

    int count();

    Optional<Book> findByIsbn(String isbn);
}
