package com.fpmislata.bookstore.controller.user.webmodel;

import com.fpmislata.bookstore.domain.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameCollectionMapper {

    GameCollectionMapper INSTANCE = Mappers.getMapper(GameCollectionMapper.class);

    @Mapping(target = "link", source = "gameCode", qualifiedByName = "setLink")
    GameCollection toGameCollection(Game game);


    @Named("setLink")
    static String setLink(String gameCode) {
        return "http://localhost:8080/api/games/" + gameCode;
    }
}
