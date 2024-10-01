package com.fpmislata.bookstore.persistence.impl.jdbc;

import com.fpmislata.bookstore.domain.model.Publisher;
import com.fpmislata.bookstore.persistence.PublisherRepository;
import com.fpmislata.bookstore.persistence.impl.jdbc.mapper.PublisherRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PublisherRepositoryJdbc implements PublisherRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Publisher getByIsbnBook(String isbn) {
        String sql = """
                SELECT * FROM publishers
                JOIN books ON publishers.id = books.publisher_id
                WHERE books.isbn = ?
                """;
        return jdbcTemplate.queryForObject(sql, new PublisherRowMapper(), isbn);
    }
}
