package com.fpmislata.bookstore.persistence.dao.db.jdbc;

import com.fpmislata.bookstore.domain.model.Movie;
import com.fpmislata.bookstore.persistence.dao.db.MovieDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.MovieRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;
import java.util.List;

public class MovieDaoJdbc implements MovieDaoDb {

    private static JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAll(Integer page, Integer size) {
        String sql = """
                SELECT * FROM movies
                LIMIT ?
                OFFSET ?
                """;
        return jdbcTemplate.query(sql, new MovieRowMapper(), size, page * size);
    }
}