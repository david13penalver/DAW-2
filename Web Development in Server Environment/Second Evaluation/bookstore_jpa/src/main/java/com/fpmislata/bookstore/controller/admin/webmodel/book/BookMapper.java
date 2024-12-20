package com.fpmislata.bookstore.controller.admin.webmodel.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.awt.print.Book;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "title", source = "book.title")
    BookCollection toBookCollection(Book book);

}
