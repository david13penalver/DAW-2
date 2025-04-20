package com.bs24.demo.domain.usecase.sessionexercises.session.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.domain.service.SessionExercisesService;
import com.bs24.demo.domain.usecase.sessionexercises.session.SessionExercisesUpdateUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class SessionExercisesUpdateUseCaseImpl implements SessionExercisesUpdateUseCase {

    private final SessionExercisesService sessionExercisesService;

    @Override
    public void execute(SessionExercises sessionExercises) {
        sessionExercisesService.save(sessionExercises);
    }
}
