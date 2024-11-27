package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Category;
import com.fpmislata.bookstore.domain.repository.CategoryRepository;
import com.fpmislata.bookstore.domain.service.CategoryService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
}
