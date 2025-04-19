package com.bs24.demo.domain.usecase.session;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.Session;

public interface SessionFindByIdUseCase {
    Session execute(int sessionId);
}
