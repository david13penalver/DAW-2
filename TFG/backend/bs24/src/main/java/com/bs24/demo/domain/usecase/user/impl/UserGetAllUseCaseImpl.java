package com.bs24.demo.domain.usecase.user.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.User;
import com.bs24.demo.domain.service.UserService;
import com.bs24.demo.domain.usecase.user.UserGetAllUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class UserGetAllUseCaseImpl implements UserGetAllUseCase {

    private final UserService  userService;

    @Override
    public ListWithCount<User> execute(int page, int pageSize) {
        return userService.getAll(page, pageSize);
    }
}
