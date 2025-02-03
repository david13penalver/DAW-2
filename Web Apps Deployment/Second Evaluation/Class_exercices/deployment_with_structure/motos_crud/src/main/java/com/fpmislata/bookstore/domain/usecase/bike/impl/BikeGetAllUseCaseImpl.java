package com.fpmislata.bookstore.domain.usecase.bike.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.model.Bike;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.service.BikeService;
import com.fpmislata.bookstore.domain.usecase.bike.BikeGetAllUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BikeGetAllUseCaseImpl implements BikeGetAllUseCase {

    private final BikeService bikeService;

    @Override
    public ListWithCount<Bike> execute(int page, int pageSize) {
        return bikeService.getAll(page, pageSize);
    }
}
