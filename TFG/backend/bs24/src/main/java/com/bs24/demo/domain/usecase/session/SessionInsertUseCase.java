package com.bs24.demo.domain.usecase.session;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.Session;

public interface SessionInsertUseCase {
    void execute(Session session);
}
