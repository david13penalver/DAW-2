package com.bs24.demo.domain.usecase.sessionexercises.session;

import com.bs24.demo.domain.model.SessionExercises;

public interface SessionExercisesFindByIdUseCase {
    SessionExercises execute(int sessionExercisesId);
}
