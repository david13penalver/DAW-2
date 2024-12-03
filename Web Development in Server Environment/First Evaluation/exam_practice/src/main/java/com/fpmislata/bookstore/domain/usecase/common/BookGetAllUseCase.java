package com.fpmislata.bookstore.domain.usecase.common;

import com.fpmislata.bookstore.domain.model.Book;

import java.util.Collection;
import java.util.List;

public interface BookGetAllUseCase {
    List<Book> execute(int i, int pageSize);
}
