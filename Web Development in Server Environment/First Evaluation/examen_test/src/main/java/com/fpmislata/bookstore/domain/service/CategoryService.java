package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Category;

import java.util.Optional;

public interface CategoryService {

    Optional<Category> findById(Long id);
}
