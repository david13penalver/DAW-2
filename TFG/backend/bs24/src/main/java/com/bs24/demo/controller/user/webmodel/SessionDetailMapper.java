package com.bs24.demo.controller.user.webmodel;

import com.bs24.demo.domain.model.Session;
import org.mapstruct.Mapper;

@Mapper(uses = {UserDetailMapper.class})
public interface SessionDetailMapper {

    SessionDetailMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(SessionDetailMapper.class);

    SessionDetail toSessionDetail(Session session);

    Session toSession(SessionDetail sessionDetail);

}
