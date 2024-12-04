package com.fpmislata.bookstore.domain.usecase.common.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.service.OrderService;
import com.fpmislata.bookstore.domain.usecase.common.OrderCountUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class OrderCountUseCaseImpl implements OrderCountUseCase {

    private final OrderService orderService;
    @Override
    public int execute() {
        return orderService.count();
    }
}
