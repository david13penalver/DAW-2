package com.bs24.demo.domain.usecase.sessionexercises.session.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.domain.service.SessionExercisesService;
import com.bs24.demo.domain.service.SessionService;
import com.bs24.demo.domain.usecase.sessionexercises.session.SessionExercisesGetAllUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class SessionExercisesGetAllUseCaseImpl implements SessionExercisesGetAllUseCase {

    private final SessionExercisesService sessionExercisesService;

    @Override
    public ListWithCount<SessionExercises> execute(int page, int pageSize) {
        return sessionExercisesService.getAll(page, pageSize);
    }
}
