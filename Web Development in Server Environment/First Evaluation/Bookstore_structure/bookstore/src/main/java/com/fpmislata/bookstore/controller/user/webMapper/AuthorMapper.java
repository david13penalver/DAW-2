package com.fpmislata.bookstore.controller.user.webMapper;

import com.fpmislata.bookstore.controller.user.webModel.AuthorCollection;
import com.fpmislata.bookstore.domain.user.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorCollection toAuthorCollection(Author author);
}
