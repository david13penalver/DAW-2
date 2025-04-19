package com.bs24.demo.domain.usecase.user.impl;

import com.bs24.demo.common.annotation.DomainTransactional;
import com.bs24.demo.common.annotation.DomainUseCase;
import com.bs24.demo.common.exception.ResourceNotFoundException;
import com.bs24.demo.domain.model.User;
import com.bs24.demo.domain.service.UserService;
import com.bs24.demo.domain.usecase.user.UserFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class UserFindByIdUseCaseImpl implements UserFindByIdUseCase {

    private final UserService userService;

    @Override
    public User execute(int userId) {
        return userService.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found"));
    }
}
