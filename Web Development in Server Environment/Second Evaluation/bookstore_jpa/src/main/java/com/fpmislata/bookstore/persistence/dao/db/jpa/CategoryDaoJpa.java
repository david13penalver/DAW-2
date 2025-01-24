package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.Category;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.persistence.dao.db.GenericDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.CategoryEntity;
import com.fpmislata.bookstore.persistence.dao.db.jpa.mapper.CategoryJpaMapper;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.CategoryJpaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Repository
@AllArgsConstructor
@Primary
public class CategoryDaoJpa implements GenericDaoDb<Category> {

    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryJpaMapper categoryJpaMapper;

    @Override
    public List<Category> getAll() {
        return categoryJpaRepository.findAll()
                .stream()
                .map(CategoryJpaMapper.INSTANCE::toCategory)
                .toList();
    }

    @Override
    public ListWithCount<Category> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CategoryEntity> categoryPage = categoryJpaRepository.findAll(pageable);
        return new ListWithCount<Category>(
                categoryJpaRepository.findAll(pageable)
                        .stream()
                        .map(CategoryJpaMapper.INSTANCE::toCategory)
                        .toList(),
                categoryPage.getTotalElements()
        );

    }

    @Override
    public Optional<Category> findById(long id) {
        return categoryJpaRepository.findById(id)
                .map(CategoryJpaMapper.INSTANCE::toCategory);
    }

    @Override
    public long insert(Category category) {
        return categoryJpaRepository.save(CategoryJpaMapper.INSTANCE.toCategoryEntiry(category)).getId();
    }

    @Override
    public void update(Category category) {
        categoryJpaRepository.save(CategoryJpaMapper.INSTANCE.toCategoryEntiry(category));
    }

    @Override
    public void delete(long id) {
        categoryJpaRepository.deleteById(id);
    }

    @Override
    public long count() {
        return categoryJpaRepository.count();
    }

    @Override
    public Category save(Category category) {
        return categoryJpaMapper.toCategory(
                categoryJpaRepository.save(CategoryJpaMapper.INSTANCE.toCategoryEntiry(category))
        );
    }
}
