package com.fpmislata.bookstore.persistence.dao.db.jdbc;

import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.persistence.dao.db.GenreDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.GenreRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GenreDaoJdbc implements GenreDaoDb {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Genre> getByIdBook(long idBook) {
        String sql = """
                SELECT genres.* FROM genres
                JOIN books_genres ON genres.id = books_genres.genre_id
                AND books_genres.book_id = ?
           """;
        return jdbcTemplate.query(sql, new GenreRowMapper(),idBook);
    }

    @Override
    public List<Genre> findAllById(Long[] ids) {
        return List.of();
    }

    @Override
    public List<Genre> getByIsbnBook(String isbn) {
        return List.of();
    }

    @Override
    public List<Genre> getAll() {
        return List.of();
    }

    @Override
    public List<Genre> getAll(int page, int size) {
        return List.of();
    }

    @Override
    public Optional<Genre> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Genre genre) {
        return 0;
    }

    @Override
    public void update(Genre genre) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(Genre genre) {

    }
}
