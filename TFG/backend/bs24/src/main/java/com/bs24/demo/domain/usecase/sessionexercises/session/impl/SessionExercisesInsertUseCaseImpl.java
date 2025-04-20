package com.bs24.demo.domain.usecase.sessionexercises.session.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.common.exception.ResourceAlreadyExistsException;
import com.bs24.demo.common.exception.ResourceNotFoundException;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.domain.service.SessionExercisesService;
import com.bs24.demo.domain.service.SessionService;
import com.bs24.demo.domain.service.UserService;
import com.bs24.demo.domain.usecase.sessionexercises.session.SessionExercisesInsertUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class SessionExercisesInsertUseCaseImpl implements SessionExercisesInsertUseCase {

    private final SessionExercisesService sessionExercisesService;
    private final UserService userService;

    @Override
    public void execute(SessionExercises sessionExercises) {
        if (sessionExercisesService.findById(sessionExercises.getSessionExercisesId()).isPresent()) {
            throw  new ResourceAlreadyExistsException("Exercise session with ID " + sessionExercises.getSessionExercisesId() + " already exists");
        }

//        session.setUser(
//                userService.findById(session.getUser().getUserId())
//                        .orElseThrow(() -> new ResourceNotFoundException("User not found"))
//        );

        sessionExercisesService.save(sessionExercises);
    }
}
