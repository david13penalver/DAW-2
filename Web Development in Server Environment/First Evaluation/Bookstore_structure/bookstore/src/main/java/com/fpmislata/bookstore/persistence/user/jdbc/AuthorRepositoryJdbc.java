package com.fpmislata.bookstore.persistence.user.jdbc;

import com.fpmislata.bookstore.domain.user.model.Author;
import com.fpmislata.bookstore.persistence.user.AuthorRepository;
import com.fpmislata.bookstore.persistence.user.jdbc.mapper.AuthorRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthorRepositoryJdbc implements AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Author> getAll() {
        String sql = """
                SELECT * FROM authors
                """;
        return jdbcTemplate.query(sql, new AuthorRowMapper());
    }

    @Override
    public Optional<Author> findById(int id) {
        String sql = """
                SELECT * FROM authors
                WHERE id = ?
                """;
        return Optional.of(jdbcTemplate.queryForObject(sql, new AuthorRowMapper(), id));
    }

    public List<Author> getByIsbnBook(String isbn) {
        String sql = """
                SELECT authors.* FROM authors
                JOIN books_authors ON authors.id = books_authors.author_id
                JOIN books ON books_authors.book_id = books.id
                AND books.isbn = ?
           """;
        return jdbcTemplate.query(sql, new AuthorRowMapper(), isbn);
    }
}
