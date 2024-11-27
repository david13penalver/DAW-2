package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
    @Override
    public List<Author> getByIdBook(long idBook) {
        return List.of();
    }

    @Override
    public List<Author> findAllById(Long[] array) {
        return List.of();
    }
}
