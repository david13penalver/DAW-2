package com.fpmislata.bookstore.domain.usecase.bike;

import com.fpmislata.bookstore.domain.model.Bike;
import com.fpmislata.bookstore.domain.model.ListWithCount;

public interface BikeGetAllUseCase {
    ListWithCount<Bike> execute(int page, int pageSize);
}
