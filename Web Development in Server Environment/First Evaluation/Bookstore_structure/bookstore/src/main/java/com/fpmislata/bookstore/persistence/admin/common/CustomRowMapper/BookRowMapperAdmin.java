package com.fpmislata.bookstore.persistence.admin.common.CustomRowMapper;

import com.fpmislata.bookstore.domain.admin.model.Book;

public class BookRowMapperAdmin {
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
        if(this.existsColumn(resultSet, "publishers.id")) {
        book.setPublisher(publisherRowMapper.mapRow(resultSet, rowNum));
    }
        if(this.existsColumn(resultSet, "categories.id")) {
        book.setCategory(categoryRowMapper.mapRow(resultSet, rowNum));
    }
        return book;
}
}
