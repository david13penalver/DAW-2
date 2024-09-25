package com.fpmislata.bookstore.persistence.impl.jdbc;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Category;
import com.fpmislata.bookstore.persistence.BookRepository;
import com.fpmislata.bookstore.persistence.impl.jdbc.mapper.BookRowMapper;
import com.fpmislata.bookstore.persistence.impl.jdbc.mapper.CategoryRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@Component
public class BookRepositoryJdbc implements BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAll() {
        String sql = """
                SELECT * FROM books
                LEFT JOIN categories ON books.category_id = categories.id
                LEFT JOIN publishers ON books.publisher_id = publishers.id
                """;
//        String sql = """
//                SELECT books.title_es FROM books;
//                """;
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        String sql = """
                SELECT * FROM books
                LEFT JOIN categories ON books.category_id = categories.id
                LEFT JOIN publishers ON books.publisher_id = publishers.id
                WHERE isbn = ?
                """;
        return Optional.of(jdbcTemplate.queryForObject(sql, new BookRowMapper(), isbn));
//        try {
//            Book book = jdbcTemplate.queryForObject(sql, new BookRowMapper(), isbn);
//            CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
//            Category category = categoryRowMapper.mapRow((ResultSet) book, 0);
//            return Optional.of(book);
//        } catch (Exception e) {
//            return Optional.empty();
//        }
    }
}
