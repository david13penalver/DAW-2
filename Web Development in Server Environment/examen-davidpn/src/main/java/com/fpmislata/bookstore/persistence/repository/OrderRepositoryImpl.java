package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Order;
import com.fpmislata.bookstore.domain.repository.OrderRepository;
import com.fpmislata.bookstore.persistence.dao.db.OrderDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderDaoDb orderDaoDb;
    @Override
    public List<Order> getAll(int size, int page) {
        return orderDaoDb.getAll(size, page);
    }

    @Override
    public int count() {
        return orderDaoDb.count();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderDaoDb.findById(id);
    }
}
