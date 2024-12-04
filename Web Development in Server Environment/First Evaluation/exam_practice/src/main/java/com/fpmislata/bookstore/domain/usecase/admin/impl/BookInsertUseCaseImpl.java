package com.fpmislata.bookstore.domain.usecase.admin.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.common.exception.ResourceAlreadyExistsException;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.service.*;
import com.fpmislata.bookstore.domain.usecase.admin.BookInsertUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookInsertUseCaseImpl implements BookInsertUseCase {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @Override
    public void execute(Book book) {
        if (bookService.findByIsbn(book.getIsbn()).isPresent()) {
            throw new ResourceAlreadyExistsException("Book with ISBN " + book.getIsbn() + " already exists");
        }
        book.setPublisher(publisherService
                .findById(book.getPublisher().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Publisher " + book.getPublisher().getName() + " not found")));
        book.setCategory(categoryService
                .findById(book.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category " + book.getCategory().getId() + " not found")));
        book.setAuthors(authorService
                .findAllById(book.getAuthors()));
        book.setGenres(genreService
                .findAllById(book.getGenres()));

        bookService.save(book);
    }
}
