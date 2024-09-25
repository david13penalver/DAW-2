package com.fpmislata.bookstore.persistence.impl.jdbc.mapper;

import com.fpmislata.bookstore.domain.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setIsbn(rs.getString("books.isbn"));
        book.setTitle(rs.getString("books.title_es"));
        book.setSynopsis(rs.getString("books.synopsis_es"));
        book.setPrice(new BigDecimal(rs.getString("books.price")));
        book.setDiscount(rs.getFloat("books.discount"));
        book.setCover(rs.getString("books.cover"));
        return book;
    }
}
