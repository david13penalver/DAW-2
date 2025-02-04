package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Director;
import com.fpmislata.bookstore.domain.repository.DirectorRepository;
import com.fpmislata.bookstore.domain.service.DirectorService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    @Override
    public Optional<Director> findById(Long id) {
        return directorRepository.findById(id);
    }
}
