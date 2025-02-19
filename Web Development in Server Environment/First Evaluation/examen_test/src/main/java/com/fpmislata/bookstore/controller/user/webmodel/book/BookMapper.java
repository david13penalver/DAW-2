package com.fpmislata.bookstore.controller.user.webmodel.book;

import com.fpmislata.bookstore.controller.user.webmodel.author.AuthorMapper;
import com.fpmislata.bookstore.controller.user.webmodel.genre.GenreMapper;
import com.fpmislata.bookstore.controller.user.webmodel.publisher.PublisherMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper (uses = {PublisherMapper.class, AuthorMapper.class, GenreMapper.class})
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookCollection toBookCollection(com.fpmislata.bookstore.domain.model.Book book);

    @Mapping(target = "publisherCollection", source = "publisher")
    @Mapping(target = "authorsCollection", source = "authors")
    @Mapping(target = "category", source = "category.name")
    @Mapping(target = "genres", source = "genres")
    BookDetail toBookDetail(com.fpmislata.bookstore.domain.model.Book book);
}
