package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Author;

import java.util.List;

public interface AuthorRepository {
    List<Author> findAllById(Long[] ids);
}
