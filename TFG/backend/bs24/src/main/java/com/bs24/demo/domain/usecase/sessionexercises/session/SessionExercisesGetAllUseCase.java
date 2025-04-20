package com.bs24.demo.domain.usecase.sessionexercises.session;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.SessionExercises;

public interface SessionExercisesGetAllUseCase {
    ListWithCount<SessionExercises> execute(int page, int pageSize);
}
