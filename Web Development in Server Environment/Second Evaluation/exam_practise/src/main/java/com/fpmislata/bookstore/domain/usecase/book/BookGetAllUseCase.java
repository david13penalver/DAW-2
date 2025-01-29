package com.fpmislata.bookstore.domain.usecase.book;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.ListWithCount;

public interface BookGetAllUseCase {
    ListWithCount<Book> execute(int page, int pageSize);
}
