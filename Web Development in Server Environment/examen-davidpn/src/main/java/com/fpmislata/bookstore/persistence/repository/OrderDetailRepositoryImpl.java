package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.OrderDetail;
import com.fpmislata.bookstore.domain.repository.OrderDetailRepository;
import com.fpmislata.bookstore.persistence.dao.db.OrderDetailDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderDetailRepositoryImpl implements OrderDetailRepository {

    private final OrderDetailDaoDb orderDetailDaoDb;

//    @Override
//    public OrderDetail addBook(Long idOrder, Optional<Book> book) {
//        return orderDetailDaoDb.addBook(idOrder, book);
//    }
}
