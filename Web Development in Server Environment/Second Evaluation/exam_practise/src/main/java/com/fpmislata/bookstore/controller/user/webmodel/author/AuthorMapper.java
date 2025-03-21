package com.fpmislata.bookstore.controller.user.webmodel.author;

import com.fpmislata.bookstore.domain.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorCollection toAuthorCollection(Author author);

    Author toAuthor(AuthorCollection authorCollection);
}
