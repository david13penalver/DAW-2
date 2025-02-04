package com.fpmislata.bookstore.controller.user.webmodel;

import com.fpmislata.bookstore.domain.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DirectorDetailMapper.class, FigureDetailMapper.class})
public interface GameDetailMapper {

    GameDetailMapper INSTANCE = Mappers.getMapper(GameDetailMapper.class);

    GameDetail toGameDetail(Game game);

    Game toGame(GameDetail gameDetail);
}
