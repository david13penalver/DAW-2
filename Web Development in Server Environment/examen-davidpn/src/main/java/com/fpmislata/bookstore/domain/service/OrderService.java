package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAll(int size, int page);

    int count();

    Optional<Order> findById(Long id);

}
