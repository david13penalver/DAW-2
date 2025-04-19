package com.bs24.demo.domain.usecase.session;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;

public interface SessionGetAllUseCase {
    ListWithCount<Session> execute(int page, int pageSize);
}
