package com.bs24.demo.persistence.dao.db;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.SessionExercises;

public interface SessionExercisesDaoDb extends GenericDaoDb<SessionExercises> {
    ListWithCount<SessionExercises> getAllBySessionId(int sessionId, int page, int pageSize);
}
