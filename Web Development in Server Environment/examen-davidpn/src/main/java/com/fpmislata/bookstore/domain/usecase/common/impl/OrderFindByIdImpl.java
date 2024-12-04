package com.fpmislata.bookstore.domain.usecase.common.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Order;
import com.fpmislata.bookstore.domain.service.OrderService;
import com.fpmislata.bookstore.domain.usecase.common.OrderFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainTransactional
@DomainService
@RequiredArgsConstructor
public class OrderFindByIdImpl implements OrderFindByIdUseCase {

    private final OrderService orderService;
    @Override
    public Order execute(Long id) {
        return orderService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order id " + id + " not found"));
    }
}
