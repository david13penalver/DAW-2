package com.fpmislata.bookstore.persistence.dao.db.jdbc.mapper;

import com.fpmislata.bookstore.domain.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements CustomRowMapper<Book>{

    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("books.id"));
        book.setIsbn(resultSet.getString("books.isbn"));
        book.setTitle(resultSet.getString("books.title_es"));

        return book;
    }
}
