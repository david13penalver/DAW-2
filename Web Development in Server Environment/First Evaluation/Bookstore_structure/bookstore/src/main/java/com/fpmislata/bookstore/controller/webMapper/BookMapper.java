package com.fpmislata.bookstore.controller.webMapper;

import com.fpmislata.bookstore.controller.webModel.BookCollection;
import com.fpmislata.bookstore.controller.webModel.BookDetail;
import com.fpmislata.bookstore.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper (uses = {AuthorMapper.class, GenreMapper.class, PublihserMapper.class})
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookCollection toBookCollection(Book book);

    @Mapping(target = "publisherCollection", source = "publisher")
    @Mapping(target = "authorCollection", source = "authors")
    @Mapping(target = "category", source = "category.name")
    @Mapping(target = "genres", source = "genres")
    BookDetail toBookDetail(Book book);
}
