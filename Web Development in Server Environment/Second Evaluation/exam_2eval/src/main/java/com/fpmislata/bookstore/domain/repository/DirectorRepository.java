package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Director;

import java.util.Optional;

public interface DirectorRepository {
    Optional<Director> findById(Long id);
}
