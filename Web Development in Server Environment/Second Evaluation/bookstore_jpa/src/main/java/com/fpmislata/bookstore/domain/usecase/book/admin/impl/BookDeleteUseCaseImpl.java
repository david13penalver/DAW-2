package com.fpmislata.bookstore.domain.usecase.book.admin.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.service.BookService;
import com.fpmislata.bookstore.domain.usecase.book.admin.BookDeleteUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookDeleteUseCaseImpl implements BookDeleteUseCase {

    private final BookService bookService;

    @Override
    public void execute(long id) {
        bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        bookService.delete(id);
    }
}
