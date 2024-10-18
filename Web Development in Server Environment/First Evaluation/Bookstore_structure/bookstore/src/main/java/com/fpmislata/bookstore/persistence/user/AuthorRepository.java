package com.fpmislata.bookstore.persistence.user;

import com.fpmislata.bookstore.domain.user.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    List<Author> getAll();

    Optional<Author> findById(int id);

    List<Author> getByIsbnBook(String isbn);
}
