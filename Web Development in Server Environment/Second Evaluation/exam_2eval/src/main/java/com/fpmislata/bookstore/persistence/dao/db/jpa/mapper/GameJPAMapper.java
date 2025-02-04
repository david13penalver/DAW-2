package com.fpmislata.bookstore.persistence.dao.db.jpa.mapper;

import com.fpmislata.bookstore.domain.model.Game;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.DirectorJPA;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.FigureJPA;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.GameJPA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {DirectorJPA.class, FigureJPA.class})
public interface GameJPAMapper {

    GameJPAMapper INSTANCE = Mappers.getMapper(GameJPAMapper.class);

    Game toGame(GameJPA gameJPA);

    GameJPA toGameJPA(Game game);
}
