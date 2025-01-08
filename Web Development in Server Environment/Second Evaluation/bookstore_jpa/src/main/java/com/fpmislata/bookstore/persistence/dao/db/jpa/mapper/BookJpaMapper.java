package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AuthorJpaMapper.class, PublisherJpaMapper.class, GenreJpaMapper.class, CategoryJpaMapper.class})
public interface BookJpaMapper {

    BookJpaMapper INSTANCE = Mappers.getMapper(BookJpaMapper.class);

    Book toBookWithDetails(BookEntity bookEntity);

    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    Book toBook(BookEntity bookEntity);

    BookEntity toBookEntity(Book book);
}
