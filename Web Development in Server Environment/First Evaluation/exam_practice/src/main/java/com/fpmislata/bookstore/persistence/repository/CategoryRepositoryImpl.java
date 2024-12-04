package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Category;
import com.fpmislata.bookstore.domain.repository.CategoryRepository;
import com.fpmislata.bookstore.persistence.dao.db.CategoryDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryDaoDb categoryDaoDb;

    @Override
    public Optional<Category> findById(Long id) {
        return categoryDaoDb.findById(id);
    }
}
