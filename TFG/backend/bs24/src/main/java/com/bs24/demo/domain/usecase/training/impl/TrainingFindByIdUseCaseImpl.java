package com.bs24.demo.domain.usecase.training.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.common.exception.ResourceNotFoundException;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.Training;
import com.bs24.demo.domain.service.SessionService;
import com.bs24.demo.domain.service.TrainingService;
import com.bs24.demo.domain.usecase.session.SessionFindByIdUseCase;
import com.bs24.demo.domain.usecase.training.TrainingFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class TrainingFindByIdUseCaseImpl implements TrainingFindByIdUseCase {

    private final TrainingService trainingService;

    @Override
    public Training execute(int trainingId) {
        return trainingService.findById(trainingId)
                .orElseThrow(() -> new ResourceNotFoundException("Training not found with id: " + trainingId));
    }
}
