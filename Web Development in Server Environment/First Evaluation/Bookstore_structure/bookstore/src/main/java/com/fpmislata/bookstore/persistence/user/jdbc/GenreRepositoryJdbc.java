package com.fpmislata.bookstore.persistence.user.jdbc;

import com.fpmislata.bookstore.domain.user.model.Genre;
import com.fpmislata.bookstore.persistence.user.GenreRepository;
import com.fpmislata.bookstore.persistence.user.jdbc.mapper.GenreRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreRepositoryJdbc implements GenreRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Genre> getByIsbnBook(String isbn) {
        String sql = """
                SELECT genres.* FROM genres
                JOIN books_genres ON genres.id = books_genres.genre_id
                JOIN books ON books_genres.book_id = books.id
                AND books.isbn = ?
                """;
        return jdbcTemplate.query(sql, new GenreRowMapper(), isbn);
    }

    @Override
    public List<Genre> getAll() {
        String sql = "SELECT * FROM genres";
        return jdbcTemplate.query(sql, new GenreRowMapper());
    }
}
