package com.bs24.demo.controller.user.webmodel;

import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.SessionExercises;
import org.mapstruct.Mapper;

@Mapper(uses = {SessionDetailMapper.class, ExerciseDetailMapper.class})
public interface SessionExercisesDetailMapper {

    SessionExercisesDetailMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(SessionExercisesDetailMapper.class);

    SessionExercisesDetail toSessionExercisesDetail(SessionExercises sessionExercises);

    SessionExercises toSessionExercises(SessionExercisesDetail sessionExercisesDetail);

}
