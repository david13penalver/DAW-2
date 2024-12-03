package com.fpmislata.bookstore.domain.usecase.admin;

import com.fpmislata.bookstore.domain.model.Book;

public interface BookInsertUseCase {
    void execute(Book book);
}
