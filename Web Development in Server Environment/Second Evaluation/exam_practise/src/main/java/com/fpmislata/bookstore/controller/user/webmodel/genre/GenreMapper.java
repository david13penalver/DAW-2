package com.fpmislata.bookstore.controller.user.webmodel.genre;

import com.fpmislata.bookstore.domain.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    GenreCollection toGenreCollection(Genre genre);

    Genre toGenre(GenreCollection genreCollection);
}
