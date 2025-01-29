package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.controller.user.webmodel.author.AuthorMapper;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AuthorMapper.class, CategoryJpaMapper.class, GenreJpaMapper.class, PublisherJpaMapper.class})
public interface BookJpaMappper {

    BookJpaMappper INSTANCE = Mappers.getMapper(BookJpaMappper.class);

    Book toBook(BookEntity bookEntity);

    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "category", ignore = true)
    Book toBookWithoutDetails(BookEntity bookEntity);

    BookEntity toBookEntity(Book book);
}
