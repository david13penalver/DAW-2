package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Bike;
import com.fpmislata.bookstore.domain.model.ListWithCount;

public interface BikeRepository {
    ListWithCount<Bike> getAll(int page, int pageSize);
}
