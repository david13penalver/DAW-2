package com.bs24.demo.controller.user.webmodel;

import com.bs24.demo.domain.model.Exercise;
import org.mapstruct.Mapper;

@Mapper
public interface ExerciseCollectionMapper {

    ExerciseCollectionMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ExerciseCollectionMapper.class);

    ExerciseCollection toExerciseCollection(Exercise exercise);

    Exercise toExercise(ExerciseCollection exerciseCollection);

}
