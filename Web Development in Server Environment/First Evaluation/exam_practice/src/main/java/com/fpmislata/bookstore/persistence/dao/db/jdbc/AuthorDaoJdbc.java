package com.fpmislata.bookstore.persistence.dao.db.jdbc;

import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.persistence.dao.db.AuthorDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.AuthorRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthorDaoJdbc implements AuthorDaoDb {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Author> getByIsbnBook(String isbn) {
        String sql = """
                SELECT authors.* FROM authors
                JOIN books_authors ON authors.id = books_authors.author_id
                JOIN books ON books_authors.book_id = books.id
                AND books.isbn = ?
           """;
        return jdbcTemplate.query(sql, new AuthorRowMapper(), isbn);
    }

    @Override
    public List<Author> getByIdBook(long idBook) {
        String sql = """
                SELECT authors.* FROM authors
                JOIN books_authors ON authors.id = books_authors.author_id
                AND books_authors.book_id = ?
           """;
        return jdbcTemplate.query(sql, new AuthorRowMapper(), idBook);
    }

    @Override
    public List<Author> findAllById(Long[] ids) {
        return List.of();
    }

    @Override
    public List<Author> getAll() {
        return List.of();
    }

    @Override
    public List<Author> getAll(int page, int size) {
        return List.of();
    }

    @Override
    public Optional<Author> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Author author) {
        return 0;
    }

    @Override
    public void update(Author author) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(Author author) {

    }
}
