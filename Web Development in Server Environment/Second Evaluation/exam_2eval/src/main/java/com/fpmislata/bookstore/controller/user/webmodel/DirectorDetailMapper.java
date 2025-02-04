package com.fpmislata.bookstore.controller.user.webmodel;

import com.fpmislata.bookstore.domain.model.Director;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DirectorDetailMapper {

    DirectorDetailMapper INSTANCE = Mappers.getMapper(DirectorDetailMapper.class);

    DirectorDetail toDirectorDetail(Director director);

    Director toDirector(DirectorDetail directorDetail);
}
