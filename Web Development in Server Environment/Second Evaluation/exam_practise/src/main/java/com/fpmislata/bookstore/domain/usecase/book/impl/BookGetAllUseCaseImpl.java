package com.fpmislata.bookstore.domain.usecase.book.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.service.BookService;
import com.fpmislata.bookstore.domain.usecase.book.BookGetAllUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookGetAllUseCaseImpl implements BookGetAllUseCase {

    private final BookService bookService;

    @Override
    public ListWithCount<Book> execute(int page, int pageSize) {
        return bookService.getAll(page, pageSize);
    }
}
