package com.fpmislata.bookstore.persistence.repository.impl;

import com.fpmislata.bookstore.domain.model.Director;
import com.fpmislata.bookstore.domain.repository.DirectorRepository;
import com.fpmislata.bookstore.persistence.dao.db.DirectorDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DirectorRepositoryImpl implements DirectorRepository {

    private final DirectorDaoDb directorDaoDb;

    @Override
    public Optional<Director> findById(Long id) {
        return directorDaoDb.findById(id);
    }
}
