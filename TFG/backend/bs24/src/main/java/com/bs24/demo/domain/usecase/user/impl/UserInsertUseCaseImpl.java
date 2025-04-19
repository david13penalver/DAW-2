package com.bs24.demo.domain.usecase.user.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.domain.model.User;
import com.bs24.demo.domain.service.UserService;
import com.bs24.demo.domain.usecase.user.UserInsertUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class UserInsertUseCaseImpl implements UserInsertUseCase {

    private final UserService userService;
    @Override
    public void execute(User user) {
        userService.save(user);
    }
}
