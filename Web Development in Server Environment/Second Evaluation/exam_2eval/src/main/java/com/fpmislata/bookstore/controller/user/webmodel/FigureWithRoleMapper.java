package com.fpmislata.bookstore.controller.user.webmodel;

import com.fpmislata.bookstore.domain.model.Figure;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FigureWithRoleMapper {

    FigureWithRoleMapper INSTANCE = Mappers.getMapper(FigureWithRoleMapper.class);

    FigureWithRole toFigureWithRole(Figure figure);
}
