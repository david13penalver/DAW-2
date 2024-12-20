package com.fpmislata.bookstore.controller.user.webmodel.book;

import com.fpmislata.bookstore.controller.user.webmodel.author.AuthorMapper;
import com.fpmislata.bookstore.controller.user.webmodel.genre.GenreMapper;
import com.fpmislata.bookstore.controller.user.webmodel.publisher.PublisherMapper;
import com.fpmislata.bookstore.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PublisherMapper.class, AuthorMapper.class, GenreMapper.class})
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookCollection toBookCollection(Book book);

    @Mapping(target = "category", source = "category.name")
    BookDetail toBookDetail(Book book);

}
