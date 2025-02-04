package com.fpmislata.bookstore.controller.user.webmodel;

import com.fpmislata.bookstore.domain.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {FigureWithRoleMapper.class})
public interface GameWithRoleMapper {

    GameWithRoleMapper INSTANCE = Mappers.getMapper(GameWithRoleMapper.class);

    GameWithRole toGameWithRole(Game game);

    Game toGame(GameWithRole gameWithRole);
}
