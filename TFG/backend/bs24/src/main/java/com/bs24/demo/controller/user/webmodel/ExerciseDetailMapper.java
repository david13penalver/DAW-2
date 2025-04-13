package com.bs24.demo.controller.user.webmodel;

import com.bs24.demo.domain.model.Exercise;
import org.mapstruct.Mapper;

@Mapper(uses = {ExerciseSubtypeCollectionMapper.class, ExerciseTypeCollectionMapper.class})
public interface ExerciseDetailMapper {

    ExerciseDetailMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ExerciseDetailMapper.class);

    ExerciseDetail toExerciseDetail(Exercise exercise);

    Exercise toExercise(ExerciseDetail exerciseDetail);

}
