package com.bs24.demo.controller.user.webmodel;

import org.mapstruct.Mapper;

@Mapper
public interface ExerciseSubtypeCollectionMapper {

    ExerciseSubtypeCollectionMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ExerciseSubtypeCollectionMapper.class);

    ExerciseSubtypeCollection toExerciseSubtypeCollection(ExerciseSubtypeCollection exerciseSubtype);

    ExerciseSubtypeCollection toExerciseSubtype(ExerciseSubtypeCollection exerciseSubtypeCollection);
}
