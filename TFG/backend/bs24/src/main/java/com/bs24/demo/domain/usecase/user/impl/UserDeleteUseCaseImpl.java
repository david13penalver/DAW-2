package com.bs24.demo.domain.usecase.user.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.service.UserService;
import com.bs24.demo.domain.usecase.user.UserDeleteUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class UserDeleteUseCaseImpl implements UserDeleteUseCase {

    private final UserService userService;

    @Override
    public void execute(int id) {
        userService.delete(id);
    }
}
