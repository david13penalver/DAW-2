package com.fpmislata.bookstore.persistence.repository.impl;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.repository.BookRepository;
import com.fpmislata.bookstore.persistence.dao.db.BookDaoJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookDaoJpa bookDaoJpa;

    @Override
    public ListWithCount<Book> getAll(int page, int pageSize) {
        return bookDaoJpa.getAll(page, pageSize);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookDaoJpa.findByIsbn(isbn);
    }

    @Override
    public void save(Book book) {
        bookDaoJpa.save(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookDaoJpa.findById(id);
    }
}
