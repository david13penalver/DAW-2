package com.bs24.demo.domain.usecase.training.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.Training;
import com.bs24.demo.domain.service.TrainingService;
import com.bs24.demo.domain.usecase.training.TrainingUpdateUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class TrainingUpdateUseCaseImpl implements TrainingUpdateUseCase {

    private final TrainingService trainingService;

    @Override
    public void execute(Training training) {
        trainingService.save(training);
    }
}
