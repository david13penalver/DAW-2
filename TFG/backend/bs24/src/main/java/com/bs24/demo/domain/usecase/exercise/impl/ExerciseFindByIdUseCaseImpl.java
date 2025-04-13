package com.bs24.demo.domain.usecase.exercise.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.common.exception.ResourceNotFoundException;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.service.ExerciseService;
import com.bs24.demo.domain.usecase.exercise.ExerciseFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class ExerciseFindByIdUseCaseImpl implements ExerciseFindByIdUseCase {

    private final ExerciseService exerciseService;

    @Override
    public Exercise execute(int exerciseId) {
        return exerciseService.findById(exerciseId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found"));
    }
}
