package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Director;

import java.util.Optional;


public interface DirectorService {
    Optional<Director> findById(Long id);
}
