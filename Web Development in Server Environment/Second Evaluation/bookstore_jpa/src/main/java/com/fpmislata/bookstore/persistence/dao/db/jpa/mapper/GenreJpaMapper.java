package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreJpaMapper {

    GenreJpaMapper INSTANCE = Mappers.getMapper(GenreJpaMapper.class);

    Genre toGenre(GenreEntity genreEntity);

    GenreEntity toGenreEntity(Genre genre);
}
