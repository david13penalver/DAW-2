package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDaoDb {
    List<Order> getAll(int size, int page);

    int count();

    Optional<Order> findById(Long id);
}
