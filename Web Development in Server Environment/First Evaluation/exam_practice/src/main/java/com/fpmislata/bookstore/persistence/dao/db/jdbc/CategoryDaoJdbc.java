package com.fpmislata.bookstore.persistence.dao.db.jdbc;

import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.model.Category;
import com.fpmislata.bookstore.persistence.dao.db.CategoryDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.AuthorRowMapper;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.CategoryRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryDaoJdbc implements CategoryDaoDb {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Category> getAll() {
        return List.of();
    }

    @Override
    public List<Category> getAll(int page, int size) {
        return List.of();
    }

    @Override
    public Optional<Category> findById(long id) {
        String sql = """
                SELECT * FROM categories
                WHERE id = ?
                """;
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql,new CategoryRowMapper(), id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public long insert(Category category) {
        return 0;
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(Category category) {

    }
}
