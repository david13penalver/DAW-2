package com.fpmislata.bookstore.domain.usecase.common;

import com.fpmislata.bookstore.domain.model.Order;

import java.util.Collection;
import java.util.List;

public interface GetAllUseCase {
    List<Order> execute(int size, int page);
}
