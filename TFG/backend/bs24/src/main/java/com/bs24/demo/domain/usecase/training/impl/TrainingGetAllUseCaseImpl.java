package com.bs24.demo.domain.usecase.training.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.Training;
import com.bs24.demo.domain.service.SessionService;
import com.bs24.demo.domain.service.TrainingService;
import com.bs24.demo.domain.usecase.session.SessionGetAllUseCase;
import com.bs24.demo.domain.usecase.training.TrainingGetAllUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class TrainingGetAllUseCaseImpl implements TrainingGetAllUseCase {

    private final TrainingService trainingService;

    @Override
    public ListWithCount<Training> execute(int page, int pageSize) {
        return null;
    }
}
