package com.fpmislata.bookstore.domain.usecase.admin.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.common.exception.ResourceAlreadyExistsException;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.service.BookService;
import com.fpmislata.bookstore.domain.service.PublisherService;
import com.fpmislata.bookstore.domain.usecase.admin.BookInsertUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookInsertUseCaseImpl implements BookInsertUseCase {
    private final BookService bookService;
    private final PublisherService publisherService;

    @Override
    public void execute(Book book) {
        if (bookService.findByIsbn(book.getIsbn()).isPresent()) {
            throw new ResourceAlreadyExistsException("Book with ISBN " + book.getIsbn() + " already exists");
        }
        book.setPublisher(publisherService
                .findById(book.getPublisher().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Publisher " + book.getPublisher().getName() + " not found")));
        //book.setCategory();
        //book.setAuthors();
        //book.setGenres();

        bookService.save(book);
    }
}
