package com.fpmislata.bookstore.domain.usecase.book;

import com.fpmislata.bookstore.domain.model.Book;

public interface BookFindByIsbnUseCase {
    Book execute(String isbn);
}
