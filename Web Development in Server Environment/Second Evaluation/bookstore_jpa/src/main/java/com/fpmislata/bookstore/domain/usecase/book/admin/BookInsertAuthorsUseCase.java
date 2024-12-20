package com.fpmislata.bookstore.domain.usecase.book.admin;

import com.fpmislata.bookstore.domain.model.Author;

import java.util.List;

public interface BookInsertAuthorsUseCase {
    void execute(Integer id, List<Author> authors);
}
