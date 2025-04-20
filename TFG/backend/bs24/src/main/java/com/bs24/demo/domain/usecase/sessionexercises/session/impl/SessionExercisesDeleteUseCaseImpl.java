package com.bs24.demo.domain.usecase.sessionexercises.session.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.domain.service.SessionExercisesService;
import com.bs24.demo.domain.usecase.sessionexercises.session.SessionExercisesDeleteUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class SessionExercisesDeleteUseCaseImpl implements SessionExercisesDeleteUseCase {

    private final SessionExercisesService sessionExercisesService;

    @Override
    public void execute(int id) {
        sessionExercisesService.delete(id);
    }
}
