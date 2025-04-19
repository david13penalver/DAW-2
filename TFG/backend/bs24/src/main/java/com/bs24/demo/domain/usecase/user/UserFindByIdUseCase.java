package com.bs24.demo.domain.usecase.user;

import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.User;

public interface UserFindByIdUseCase {
    User execute(int userId);
}
