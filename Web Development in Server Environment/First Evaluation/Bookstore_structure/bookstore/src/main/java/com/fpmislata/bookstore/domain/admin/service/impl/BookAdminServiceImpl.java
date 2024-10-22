package com.fpmislata.bookstore.domain.admin.service.impl;

import com.fpmislata.bookstore.domain.admin.model.Book;
import com.fpmislata.bookstore.domain.admin.service.BookAdminService;
import com.fpmislata.bookstore.persistence.admin.BookAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookAdminServiceImpl implements BookAdminService {
    private final BookAdminRepository bookAdminRepository;

    @Override
    public List<Book> getAll() {
        return bookAdminRepository.getAll();
    }

    @Override
    public List<Book> getAll(int page, int size) {
        return bookAdminRepository.getAll(page, size);
    }

    @Override
    public int count() {
        return bookAdminRepository.count();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookAdminRepository.findByIsbn(isbn).orElseThrow(() -> new RuntimeException("Book not found"));
    }
}
