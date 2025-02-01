package com.fpmislata.bookstore.domain.usecase.book;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.ListWithCount;

public interface BookGetAllBooksByAuthor {
    ListWithCount<Book> execute(Long id, int page, int pageSize);
}
