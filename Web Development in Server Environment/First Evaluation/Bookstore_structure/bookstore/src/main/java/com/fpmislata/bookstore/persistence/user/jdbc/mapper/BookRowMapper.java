package com.fpmislata.bookstore.persistence.user.jdbc.mapper;

import com.fpmislata.bookstore.common.locale.LanguageUtils;
import com.fpmislata.bookstore.domain.user.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        String language = LanguageUtils.getCurrentLanguage();
        Book book = new Book();
        book.setIsbn(rs.getString("books.isbn"));
        book.setTitle(rs.getString("books.title_" + language));
        book.setSynopsis(rs.getString("books.synopsis_" + language));
        book.setPrice(new BigDecimal(rs.getString("books.price")));
        book.setDiscount(rs.getFloat("books.discount"));
        book.setCover(rs.getString("books.cover"));
        return book;
    }
}
