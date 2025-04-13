package com.bs24.demo.persistence.dao.db.jpa.mapper;

import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.persistence.dao.db.jpa.entity.SessionExercisesJPA;
import org.mapstruct.Mapper;

@Mapper
public interface SessionExercisesJPAMapper {

    SessionExercisesJPAMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(SessionExercisesJPAMapper.class);


    SessionExercises toSessionExercises(SessionExercisesJPA sessionExercisesJPA);
    SessionExercisesJPA toSessionExercisesJPA(SessionExercises sessionExercises);
}
