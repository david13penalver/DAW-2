package com.bs24.demo.persistence.dao.db.mapper;

import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.persistence.dao.db.entity.SessionExercisesJPA;
import org.mapstruct.Mapper;

@Mapper
public interface SessionExercisesJPAMapper {

    SessionExercisesJPAMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(SessionExercisesJPAMapper.class);


    SessionExercises toSessionExercises(SessionExercisesJPA sessionExercisesJPA);
    SessionExercisesJPA toSessionExercisesJPA(SessionExercises sessionExercises);
}
