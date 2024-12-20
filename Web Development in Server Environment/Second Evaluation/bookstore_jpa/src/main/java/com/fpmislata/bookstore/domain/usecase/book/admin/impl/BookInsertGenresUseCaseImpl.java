package com.fpmislata.bookstore.domain.usecase.book.admin.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Genre;
import com.fpmislata.bookstore.domain.service.BookService;
import com.fpmislata.bookstore.domain.service.GenreService;
import com.fpmislata.bookstore.domain.usecase.book.admin.BookInsertGenresUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookInsertGenresUseCaseImpl implements BookInsertGenresUseCase {

    private final BookService bookService;
    private final GenreService genreService;

    @Override
    public void execute(Integer id, List<Genre> genres) {
        Book book = bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book " + id + " not found"));
        genreService
                .findAllById(genres)
                .forEach(genre -> bookService.addGenre(book, genre));
        bookService.save(book);
    }
}
