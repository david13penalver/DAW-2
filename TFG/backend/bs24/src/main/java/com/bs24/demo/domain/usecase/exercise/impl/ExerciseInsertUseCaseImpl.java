package com.bs24.demo.domain.usecase.exercise.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.common.exception.ResourceAlreadyExistsException;
import com.bs24.demo.controller.user.webmodel.ExerciseDetail;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.service.ExerciseService;
import com.bs24.demo.domain.service.ExerciseSubtypeService;
import com.bs24.demo.domain.service.ExerciseTypeService;
import com.bs24.demo.domain.usecase.exercise.ExerciseInsertUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class ExerciseInsertUseCaseImpl implements ExerciseInsertUseCase {

    private final ExerciseService exerciseService;
    private final ExerciseTypeService exerciseTypeService;
    private final ExerciseSubtypeService exerciseSubtypeService;

    @Override
    public void execute(Exercise exercise) {
        if (exerciseService.findById(exercise.getExerciseId()).isPresent()) {
            throw  new ResourceAlreadyExistsException("Exercise with ID " + exercise.getExerciseId() + " already exists");
        }

        exercise.setExerciseType(
                exerciseTypeService.findById(exercise.getExerciseType().getExerciseTypeId())
                        .orElseThrow(() -> new ResourceAlreadyExistsException("Exercise type not found"))
        );

        exercise.setExerciseSubtype(
                exerciseSubtypeService.findById(exercise.getExerciseSubtype().getExerciseTypeId())
                        .orElseThrow(() -> new ResourceAlreadyExistsException("Exercise type not found"))
        );

        exerciseService.save(exercise);
    }
}
