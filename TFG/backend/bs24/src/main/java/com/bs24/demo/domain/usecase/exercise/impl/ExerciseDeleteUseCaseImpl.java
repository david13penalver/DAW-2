package com.bs24.demo.domain.usecase.exercise.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.service.ExerciseService;
import com.bs24.demo.domain.usecase.exercise.ExerciseDeleteUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class ExerciseDeleteUseCaseImpl implements ExerciseDeleteUseCase {

    private final ExerciseService exerciseService;

    @Override
    public void execute(int id) {
        exerciseService.delete(id);
    }
}
