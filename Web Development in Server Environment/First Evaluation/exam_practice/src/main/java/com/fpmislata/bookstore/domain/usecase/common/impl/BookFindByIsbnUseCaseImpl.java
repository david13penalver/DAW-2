package com.fpmislata.bookstore.domain.usecase.common.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.service.BookService;
import com.fpmislata.bookstore.domain.usecase.common.BookFindByIsbnUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookFindByIsbnUseCaseImpl implements BookFindByIsbnUseCase {

    private final BookService bookService;

    @Override
    public Book execute(String isbn) {
        return bookService
                .findByIsbn(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book isbn " + isbn + " not found"));
    }
}
