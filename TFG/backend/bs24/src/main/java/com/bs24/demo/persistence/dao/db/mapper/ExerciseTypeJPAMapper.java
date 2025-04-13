package com.bs24.demo.persistence.dao.db.mapper;

import com.bs24.demo.domain.model.ExerciseType;
import com.bs24.demo.persistence.dao.db.entity.ExerciseTypeJPA;
import org.mapstruct.Mapper;

@Mapper
public interface ExerciseTypeJPAMapper {

    ExerciseTypeJPAMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ExerciseTypeJPAMapper.class);

    ExerciseType toExerciseType(ExerciseTypeJPA exerciseTypeJPA);
    ExerciseTypeJPA toExerciseTypeJPA(ExerciseType exerciseType);
}
