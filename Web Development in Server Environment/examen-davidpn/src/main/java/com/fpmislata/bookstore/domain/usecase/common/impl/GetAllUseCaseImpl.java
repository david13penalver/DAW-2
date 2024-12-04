package com.fpmislata.bookstore.domain.usecase.common.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.model.Order;
import com.fpmislata.bookstore.domain.service.OrderService;
import com.fpmislata.bookstore.domain.usecase.common.GetAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class GetAllUseCaseImpl implements GetAllUseCase {

    private final OrderService orderService;
    @Override
    public List<Order> execute(int size, int page) {
        return orderService.getAll(size, page);
    }
}
