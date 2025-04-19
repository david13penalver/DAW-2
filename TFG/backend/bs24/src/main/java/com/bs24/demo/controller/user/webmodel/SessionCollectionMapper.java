package com.bs24.demo.controller.user.webmodel;

import com.bs24.demo.domain.model.Session;
import org.mapstruct.Mapper;

@Mapper(uses = {UserDetailMapper.class})
public interface SessionCollectionMapper {

    SessionCollectionMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(SessionCollectionMapper.class);

    SessionCollection toSessionCollection(Session session);

    Session toSession(SessionCollection sessionCollection);

}
