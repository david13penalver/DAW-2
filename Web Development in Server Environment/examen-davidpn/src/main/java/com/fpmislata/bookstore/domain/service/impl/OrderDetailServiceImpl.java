package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.OrderDetail;
import com.fpmislata.bookstore.domain.repository.OrderDetailRepository;
import com.fpmislata.bookstore.domain.service.OrderDetailService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    //@Override
//    public OrderDetail addBook(Long idOrder, Optional<Book> book) {
//        return orderDetailRepository.addBook(idOrder, book);
//    }

    //@Override
    public OrderDetail addBook() {
        return null;
    }
}
