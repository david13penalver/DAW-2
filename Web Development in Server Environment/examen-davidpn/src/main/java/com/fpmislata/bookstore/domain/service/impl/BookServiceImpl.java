package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Order;
import com.fpmislata.bookstore.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Override
    public Optional<Book> findById(Long idBook) {
        return bookRepository.findById(idBook);
    }
}
