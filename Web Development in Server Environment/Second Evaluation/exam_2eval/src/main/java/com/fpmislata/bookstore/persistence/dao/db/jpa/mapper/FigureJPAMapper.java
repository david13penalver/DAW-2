package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Figure;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.FigureJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FigureJPAMapper {

    FigureJPAMapper INSTANCE = Mappers.getMapper(FigureJPAMapper.class);

    Figure toFigure(FigureJPA figureJPA);

    FigureJPA toFigureJPA(Figure figure);
}
