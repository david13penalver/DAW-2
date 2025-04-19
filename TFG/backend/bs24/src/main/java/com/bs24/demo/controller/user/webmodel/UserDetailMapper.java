package com.bs24.demo.controller.user.webmodel;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(uses = {ExerciseSubtypeCollectionMapper.class, ExerciseTypeCollectionMapper.class})
public interface UserDetailMapper {

    UserDetailMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(UserDetailMapper.class);

    UserDetail toUserDetail(User user);

    User toUser(UserDetail userDetail);

}
