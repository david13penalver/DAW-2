package com.fpmislata.bookstore.controller.common.webmodel.book;

import com.fpmislata.bookstore.domain.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    public MovieCollection toMovieCollection(Movie movie);
}
