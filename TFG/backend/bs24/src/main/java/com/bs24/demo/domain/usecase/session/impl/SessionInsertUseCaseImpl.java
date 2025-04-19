package com.bs24.demo.domain.usecase.session.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.common.exception.ResourceAlreadyExistsException;
import com.bs24.demo.common.exception.ResourceNotFoundException;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.service.*;
import com.bs24.demo.domain.usecase.exercise.ExerciseInsertUseCase;
import com.bs24.demo.domain.usecase.session.SessionInsertUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class SessionInsertUseCaseImpl implements SessionInsertUseCase {

    private final SessionService sessionService;
    private final UserService userService;

    @Override
    public void execute(Session session) {
        if (sessionService.findById(session.getSessionId()).isPresent()) {
            throw  new ResourceAlreadyExistsException("Exercise with ID " + session.getSessionId() + " already exists");
        }

        session.setUser(
                userService.findById(session.getUser().getUserId())
                        .orElseThrow(() -> new ResourceNotFoundException("User not found"))
        );

        sessionService.save(session);
    }
}
