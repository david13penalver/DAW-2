package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorDaoDb authorDaoDb;

    @Override
    public List<Author> getByIdBook(long idBook) {
        return authorDaoDb.getByIdBook(idBook);
    }

    @Override
    public List<Author> findAllById(Long[] array) {
        return authorDaoDb.findAllById(array);
    }
}
