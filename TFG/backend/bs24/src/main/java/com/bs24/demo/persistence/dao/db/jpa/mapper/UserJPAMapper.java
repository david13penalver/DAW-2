package com.bs24.demo.persistence.dao.db.jpa.mapper;

import com.bs24.demo.domain.model.User;
import com.bs24.demo.persistence.dao.db.jpa.entity.UserJPA;
import org.mapstruct.Mapper;

@Mapper
public interface UserJPAMapper {

    UserJPAMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(UserJPAMapper.class);

    User toUser(UserJPA userJPA);
    UserJPA toUserJPA(User user);
}
