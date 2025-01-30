package com.fpmislata.bookstore.domain.usecase.book.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.service.BookService;
import com.fpmislata.bookstore.domain.usecase.book.BookFindById;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookFindByIdImpl implements BookFindById {

    private final BookService bookService;

    @Override
    public Book execute(String isbn) {
        return bookService.findByIsbn(isbn).orElseThrow(
                () -> new ResourceNotFoundException("Book with ISBN " + isbn + " not found")
        );
    }
}
