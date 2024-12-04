package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.Order;
import com.fpmislata.bookstore.domain.repository.BookRepository;
import com.fpmislata.bookstore.persistence.dao.db.BookDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookDaoDb bookDaoDb;
    @Override
    public Optional<Book> findById(Long idBook) {
        return bookDaoDb.findById(idBook);
    }
}
