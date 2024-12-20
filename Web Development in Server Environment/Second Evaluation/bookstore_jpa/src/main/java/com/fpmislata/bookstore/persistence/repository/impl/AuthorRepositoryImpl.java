package com.fpmislata.bookstore.persistence.repository.impl;

import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.repository.AuthorRepository;
import com.fpmislata.bookstore.persistence.dao.db.AuthorDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorDaoDb authorDaoDb;

    /**
     * Constructor with @Qualifier annotation
     * @param isbn
     * @return
     */
    /*AuthorRepositoryImpl(@Qualifier("authorDaoJdbc") AuthorDaoDb authorDaoDb) {
        this.authorDaoDb = authorDaoDb;
    }*/

    @Override
    public List<Author> getByIsbnBook(String isbn) {
        return authorDaoDb.getByIsbnBook(isbn);
    }

    @Override
    public List<Author> getByIdBook(long idBook) {
        return authorDaoDb.getByIdBook(idBook);
    }

    @Override
    public List<Author> findAllById(Long[] ids) {
        return authorDaoDb.findAllById(ids);
    }
}
