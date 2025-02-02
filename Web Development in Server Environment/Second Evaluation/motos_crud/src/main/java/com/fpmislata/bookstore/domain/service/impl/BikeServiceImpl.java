package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Bike;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.repository.BikeRepository;
import com.fpmislata.bookstore.domain.service.BikeService;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepository;

    @Override
    public ListWithCount<Bike> getAll(int page, int pageSize) {
        return bikeRepository.getAll(page, pageSize);
    }
}
