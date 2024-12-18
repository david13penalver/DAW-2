package com.fpmislata.bookstore.persistence.dao.db.jdbc;

import com.fpmislata.bookstore.domain.model.Movie;
import com.fpmislata.bookstore.persistence.dao.db.MovieDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.MovieRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieDaoJdbc implements MovieDaoDb {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAll(Integer page, Integer size) {
        String sql = """
                SELECT * FROM movies
                LIMIT ?
                OFFSET ?
                """;
        return jdbcTemplate.query(sql, new MovieRowMapper(), size, page * size);
    }

    @Override
    public Integer count() {
        String sql = """
                SELECT COUNT(*) FROM movies
                """;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
