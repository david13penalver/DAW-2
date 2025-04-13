package com.bs24.demo.persistence.dao.db.mapper;

import com.bs24.demo.domain.model.Session;
import com.bs24.demo.persistence.dao.db.entity.SessionJPA;
import org.mapstruct.Mapper;

@Mapper
public interface SessionJPAMapper {

    SessionJPAMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(SessionJPAMapper.class);

    Session toSession(SessionJPA sessionJPA);
    SessionJPA toSessionJPA(Session session);
}
