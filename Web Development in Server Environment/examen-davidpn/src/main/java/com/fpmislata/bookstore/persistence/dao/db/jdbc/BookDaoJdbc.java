package com.fpmislata.bookstore.persistence.dao.db.jdbc;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Order;
import com.fpmislata.bookstore.persistence.dao.db.BookDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper.BookRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookDaoJdbc implements BookDaoDb {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public Optional<Book> findById(Long idBook) {
        String sql = "SELECT * FROM books WHERE id = ?";
        try {
            Book book = jdbcTemplate.queryForObject(sql, new BookRowMapper(), idBook);
            return Optional.of(book);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
