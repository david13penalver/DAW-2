package com.bs24.demo.domain.usecase.training.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.service.TrainingService;
import com.bs24.demo.domain.usecase.training.TrainingDeleteUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class TrainingDeleteUseCaseImpl implements TrainingDeleteUseCase {

    private final TrainingService trainingService;

    @Override
    public void execute(int id) {
        trainingService.delete(id);
    }
}
