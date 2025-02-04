package com.fpmislata.bookstore.controller.user.webmodel;

import com.fpmislata.bookstore.domain.model.Figure;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FigureDetailMapper {

    FigureDetailMapper INSTANCE = Mappers.getMapper(FigureDetailMapper.class);

    Figure toFigure(FigureDetail figureDetail);

    FigureDetail toFigureDetail(Figure figure);
}
