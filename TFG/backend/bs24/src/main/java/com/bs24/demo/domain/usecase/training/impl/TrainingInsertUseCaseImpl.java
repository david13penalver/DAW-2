package com.bs24.demo.domain.usecase.training.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.common.exception.ResourceAlreadyExistsException;
import com.bs24.demo.common.exception.ResourceNotFoundException;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.Training;
import com.bs24.demo.domain.service.SessionService;
import com.bs24.demo.domain.service.TrainingService;
import com.bs24.demo.domain.service.UserService;
import com.bs24.demo.domain.usecase.session.SessionInsertUseCase;
import com.bs24.demo.domain.usecase.training.TrainingInsertUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class TrainingInsertUseCaseImpl implements TrainingInsertUseCase {

    private final TrainingService trainingService;

    @Override
    public void execute(Training training) {

    }
}
