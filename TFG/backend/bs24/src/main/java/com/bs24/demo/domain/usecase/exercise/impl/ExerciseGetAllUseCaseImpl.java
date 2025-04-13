package com.bs24.demo.domain.usecase.exercise.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.service.ExerciseService;
import com.bs24.demo.domain.usecase.exercise.ExerciseGetAllUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class ExerciseGetAllUseCaseImpl implements ExerciseGetAllUseCase {

    private final ExerciseService exerciseService;

    @Override
    public ListWithCount<Exercise> execute(int page, int pageSize) {
        return exerciseService.getAll(page, pageSize);
    }
}
