package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Bike;
import com.fpmislata.bookstore.domain.model.ListWithCount;

public interface BikeService {
    ListWithCount<Bike> getAll(int page, int pageSize);
}
