package com.fpmislata.bookstore.domain.usecase.common;

import com.fpmislata.bookstore.domain.model.Order;

public interface OrderFindByIdUseCase {
    Order execute(Long id);
}
