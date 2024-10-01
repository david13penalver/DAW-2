package com.fpmislata.bookstore.persistence;

import com.fpmislata.bookstore.domain.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    List<Author> getAll();

    Optional<Author> findById(int id);

    List<Author> getByIsbnBook(String isbn);
}
