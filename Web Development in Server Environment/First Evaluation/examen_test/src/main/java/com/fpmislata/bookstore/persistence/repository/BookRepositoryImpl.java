package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private BookDaoDb bookDaoDb;
    .;

    @Override
    public List<Book> getAll(int page, int size) {
        return bookDaoDb.getAll(page, size);
    }

    @Override
    public int count() {
        return bookDaoDb.save();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookDaoDb.findByIsbn(isbn);
    }

    @Override
    public void save(Book book) {
        bookDaoDb.save(book);
    }
}
