package com.fpmislata.bookstore.persistence.admin.impl;

import com.fpmislata.bookstore.domain.admin.model.Book;
import com.fpmislata.bookstore.persistence.admin.BookAdminRepository;
import com.fpmislata.bookstore.persistence.admin.common.CustomRowMapper.BookRowMapperAdmin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookAdminRepositoryImpl implements BookAdminRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookAdminRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAll() {
        String sql = """
                SELECT * FROM book
                """;
        return jdbcTemplate.query(sql, new BookRowMapperAdmin());
    }

    @Override
    public List<Book> getAll(int page, int size) {
        String sql = """
                SELECT * FROM book
                LIMIT ?
                OFFSET ?
                """;

        return jdbcTemplate.query(sql, new BookRowMapperAdmin(), size, page * size);
    }

    @Override
    public int count() {
        String sql = """
                SELECT COUNT(*) FROM book
                """;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        String sql = """
                SELECT * FROM books
                LEFT JOIN categories ON books.category_id = categories.id
                LEFT JOIN publishers ON books.publisher_id = publishers.id
                WHERE books.isbn = ?
           """;
        try {
            Book book = jdbcTemplate.queryForObject(sql, new BookRowMapperAdmin(), isbn);
            book.setAuthors(authorAdminRepositoryAdmin.getByIsbnBook(isbn));
            book.setGenres(genreAdminRepositoryAdmin.getByIsbnBook(isbn));
            return Optional.of(book);
        } catch (Exception e) {
            return Optional.empty();
        };
    }
}
