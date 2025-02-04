package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Director;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.DirectorJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DirectorJPAMapper {

    DirectorJPAMapper INSTANCE = Mappers.getMapper(DirectorJPAMapper.class);

    Director toDirector(DirectorJPA directorJPA);

    DirectorJPA toDirectorJPA(Director director);
}
