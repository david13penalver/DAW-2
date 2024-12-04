package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Category;

import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(Long id);
}
