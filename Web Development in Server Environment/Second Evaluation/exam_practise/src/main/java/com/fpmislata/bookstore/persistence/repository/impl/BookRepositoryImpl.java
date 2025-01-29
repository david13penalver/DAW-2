package com.fpmislata.bookstore.persistence.repository.impl;

import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.repository.BookRepository;
import com.fpmislata.bookstore.persistence.dao.db.BookDaoJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookDaoJpa bookDaoJpa;

    @Override
    public ListWithCount<Book> getAll(int page, int pageSize) {
        return bookDaoJpa.getAll(page, pageSize);
    }
}
