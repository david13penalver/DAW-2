package com.bs24.demo.controller.user.webmodel;

import org.mapstruct.Mapper;

@Mapper
public interface ExerciseTypeCollectionMapper {

    ExerciseTypeCollectionMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ExerciseTypeCollectionMapper.class);

    ExerciseTypeCollection toExerciseTypeCollection(ExerciseTypeCollection exerciseType);

    ExerciseTypeCollection toExerciseType(ExerciseTypeCollection exerciseTypeCollection);
}
