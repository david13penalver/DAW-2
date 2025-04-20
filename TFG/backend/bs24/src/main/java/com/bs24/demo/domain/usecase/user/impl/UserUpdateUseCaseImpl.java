package com.bs24.demo.domain.usecase.user.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.User;
import com.bs24.demo.domain.service.UserService;
import com.bs24.demo.domain.usecase.user.UserUpdateUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class UserUpdateUseCaseImpl implements UserUpdateUseCase {

    private final UserService userService;

    @Override
    public void execute(User user) {
        userService.save(user);
    }
}
