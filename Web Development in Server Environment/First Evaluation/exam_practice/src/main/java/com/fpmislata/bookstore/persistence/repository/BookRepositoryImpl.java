package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.repository.BookRepository;
import com.fpmislata.bookstore.persistence.dao.db.BookDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookDaoDb bookDaoDb;

    @Override
    public List<Book> getAll(int i, int pageSize) {
        return bookDaoDb.getAll(i, pageSize);
    }

    @Override
    public int count() {
        return bookDaoDb.count();
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
