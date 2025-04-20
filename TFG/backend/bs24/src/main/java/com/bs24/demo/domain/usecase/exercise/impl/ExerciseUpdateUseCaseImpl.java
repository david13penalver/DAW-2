package com.bs24.demo.domain.usecase.exercise.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.service.ExerciseService;
import com.bs24.demo.domain.usecase.exercise.ExerciseUpdateUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class ExerciseUpdateUseCaseImpl implements ExerciseUpdateUseCase {

    private final ExerciseService exerciseService;

    @Override
    public void execute(Exercise exercise) {
        exerciseService.save(exercise);
    }
}
