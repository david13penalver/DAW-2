package com.bs24.demo.domain.usecase.user;

import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.User;

public interface UserGetAllUseCase {
    ListWithCount<User> execute(int page, int pageSize);
}
