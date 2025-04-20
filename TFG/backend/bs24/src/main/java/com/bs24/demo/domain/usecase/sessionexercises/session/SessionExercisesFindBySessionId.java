package com.bs24.demo.domain.usecase.sessionexercises.session;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.SessionExercises;

public interface SessionExercisesFindBySessionId {
    ListWithCount<SessionExercises> execute(int sessionId, int page, int pageSize);
}
