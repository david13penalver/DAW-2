package com.fpmislata.bookstore.domain.usecase.book.admin;

import com.fpmislata.bookstore.domain.model.Genre;

import java.util.List;

public interface BookInsertGenresUseCase {
    void execute(Integer id, List<Genre> genres);
}
