package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.ListWithCount;

public interface BookService {
    ListWithCount<Book> getAll(int page, int pageSize);
}
