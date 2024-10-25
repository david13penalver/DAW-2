package com.fpmislata.bookstore.persistence.admin.common.CustomRowMapper;

import com.fpmislata.bookstore.domain.admin.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapperAdmin implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setTitleEs(resultSet.getString("title_es"));
        book.setTitleEn(resultSet.getString("title_en"));
        book.setSynopsisEs(resultSet.getString("synopsis_es"));
        book.setSynopsisEn(resultSet.getString("synopsis_en"));
        book.setPrice(new BigDecimal(resultSet.getString("books.price")));
        book.setDiscount(resultSet.getFloat("books.discount"));
        book.setCover(resultSet.getString("books.cover"));

        // Assuming existsColumn is a method in this class or a utility class
//        if (existsColumn(resultSet, "publishers.id")) {
//            book.setPublisher(publisherRowMapper.mapRow(resultSet, rowNum));
//        }
//        if (existsColumn(resultSet, "categories.id")) {
//            book.setCategory(categoryRowMapper.mapRow(resultSet, rowNum));
//        }
        return book;
    }

    // Dummy implementation of existsColumn method
    private boolean existsColumn(ResultSet rs, String columnName) {
        try {
            rs.findColumn(columnName);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}