package com.fpmislata.bookstore.persistence.repository;

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

    public List<Author> findAllById(Long[] ids) {
        return authorDaoDb.findAllById(ids);
    }
}
