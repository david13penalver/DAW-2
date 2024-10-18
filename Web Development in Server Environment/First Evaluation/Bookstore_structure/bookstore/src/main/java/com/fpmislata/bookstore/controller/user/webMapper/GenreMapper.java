package com.fpmislata.bookstore.controller.user.webMapper;

import com.fpmislata.bookstore.domain.user.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    List<String> toGenreMapper(List<Genre> genres);

    default String toGenreName(Genre genre) {
        return genre.getName();
    }
}
