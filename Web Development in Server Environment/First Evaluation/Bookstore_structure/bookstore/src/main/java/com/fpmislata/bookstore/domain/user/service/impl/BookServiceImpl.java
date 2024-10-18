package com.fpmislata.bookstore.domain.user.service.impl;

import com.fpmislata.bookstore.common.exceptions.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.user.model.Book;
import com.fpmislata.bookstore.domain.user.service.BookService;
import com.fpmislata.bookstore.persistence.user.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public List<Book> getAll(int page, int size) {
        return bookRepository.getAll(page, size);
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("Book with isbn " + isbn + " Not Found"));
    }

    @Override
    public int count() {
        return bookRepository.count();
    }
}