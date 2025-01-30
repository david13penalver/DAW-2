package com.fpmislata.bookstore.domain.usecase.book.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.service.BookService;
import com.fpmislata.bookstore.domain.usecase.book.BookDeleteBookUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookDeleteBookUseCaseImpl implements BookDeleteBookUseCase {

    private final BookService bookService;

    @Override
    public void execute(Long id) {
        bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        bookService.delete(id);
    }
}
