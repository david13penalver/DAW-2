package com.fpmislata.bookstore.controller.webMapper;

import com.fpmislata.bookstore.controller.webModel.AuthorCollection;
import com.fpmislata.bookstore.domain.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorCollection toAuthorCollection(Author author);
}
