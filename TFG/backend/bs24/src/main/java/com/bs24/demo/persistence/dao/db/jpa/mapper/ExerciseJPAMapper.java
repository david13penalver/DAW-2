package com.bs24.demo.persistence.dao.db.jpa.mapper;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.persistence.dao.db.jpa.entity.ExerciseJPA;
import org.mapstruct.Mapper;

@Mapper
public interface ExerciseJPAMapper {

    ExerciseJPAMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ExerciseJPAMapper.class);

    Exercise toExercise(ExerciseJPA exerciseJPA);
    ExerciseJPA toExerciseJPA(Exercise exercise);
}
