package com.fpmislata.bookstore.domain.usecase.book.admin.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.service.AuthorService;
import com.fpmislata.bookstore.domain.service.BookService;
import com.fpmislata.bookstore.domain.usecase.book.admin.BookInsertAuthorsUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookInsertAuthorsUseCaseImpl implements BookInsertAuthorsUseCase {

    private final BookService bookService;
    private final AuthorService authorService;

    @Override
    public void execute(Integer id, List<Author> authors) {
        Book book = bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book " + id + " not found"));
        authorService
                .findAllById(authors)
                .forEach(author -> bookService.addAuthor(book, author));
        bookService.save(book);
    }
}
