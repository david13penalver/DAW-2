package com.bs24.demo.persistence.dao.db.mapper;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ExerciseSubtype;
import com.bs24.demo.persistence.dao.db.entity.ExerciseJPA;
import com.bs24.demo.persistence.dao.db.entity.ExerciseSubtypeJPA;
import org.mapstruct.Mapper;

@Mapper
public interface ExerciseSubtypeJPAMapper {

    ExerciseSubtypeJPAMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ExerciseSubtypeJPAMapper.class);

    ExerciseSubtype toExerciseSubtype(ExerciseSubtypeJPA exerciseSubtypeJPA);
    ExerciseSubtypeJPA toExerciseSubtypeJPA(ExerciseSubtype exerciseSubtype);
}
