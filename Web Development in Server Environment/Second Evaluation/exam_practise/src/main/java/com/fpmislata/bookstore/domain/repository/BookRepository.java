package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.ListWithCount;

public interface BookRepository {
    ListWithCount<Book> getAll(int page, int pageSize);
}
