package com.fpmislata.bookstore.domain.usecase.common.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.service.OrderDetailService;
import com.fpmislata.bookstore.domain.service.impl.BookService;
import com.fpmislata.bookstore.domain.usecase.common.InsertBookInOrderUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class InsertBookInOrderUseCaseImpl implements InsertBookInOrderUseCase {

    private final BookService bookService;
    private final OrderDetailService orderDetailService;

    //@Override
//    public Order execute(Long id, Long order_id, Long idBook, int quantity, BigDecimal price) {
//        Optional<Book> book = bookService.findById(idBook);
//        Long id_book = Optional.ofNullable(book.get().getId()).orElseThrow(
//                () -> new RuntimeException("Book not found")
//        );
//        orderDetailService.addBook(id, order_id, id_book, quantity, price);
//        return null;
//    }

    }

//
