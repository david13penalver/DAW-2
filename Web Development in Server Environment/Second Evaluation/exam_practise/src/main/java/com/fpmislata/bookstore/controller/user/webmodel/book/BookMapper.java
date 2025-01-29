package com.fpmislata.bookstore.controller.user.webmodel.book;

import com.fpmislata.bookstore.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookCollection toBookCollection(Book book);

    @Mapping(target = "category", source = "category.name")
    @Mapping(target = "publisher", source = "publisher.name")
    BookDetail toBookDetail(Book book);
}
