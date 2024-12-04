package com.fpmislata.bookstore.persistence.dao.db;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.OrderDetail;

import java.util.Optional;

public interface OrderDetailDaoDb {
    OrderDetail getById(Long id);

    //OrderDetail addBook(Long idOrder, Optional<Book> book);
}
