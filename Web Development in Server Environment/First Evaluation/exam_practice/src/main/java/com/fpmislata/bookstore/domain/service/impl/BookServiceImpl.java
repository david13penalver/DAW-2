package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.repository.BookRepository;
import com.fpmislata.bookstore.domain.service.BookService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAll(int i, int pageSize) {
        return bookRepository.getAll(i, pageSize);
    }

    @Override
    public int count() {
        return bookRepository.count();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
}
