package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Order;
import com.fpmislata.bookstore.domain.repository.OrderRepository;
import com.fpmislata.bookstore.domain.service.OrderService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public List<Order> getAll(int size, int page) {
//        List<Order> orders = orderRepository
//                .getAll(size, page)
//                .forEach(
//                        order -> {
//                            order.setStatus(
//                                    if (order.getStatus().equals("0")) {
//                                        order.setStatus("Pending");
//                                    } else if (order.getStatus().equals("1")) {
//                                        order.setStatus("Actuated");
//                                    } else if (order.getStatus().equals("2")) {
//                                        order.setStatus("Cancelled");
//                                    } else if (order.getStatus().equals("3")) {
//                                        order.setStatus("In transit");
//                                    } else if (order.getStatus().equals("4")) {
//                                order.setStatus("Delivered");
//                                )
//                                .toList;
//        return orders;
        return orderRepository.getAll(size, page);
    }

    @Override
    public int count() {
        return orderRepository.count();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }
}
