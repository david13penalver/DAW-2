package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Publisher;
import com.fpmislata.bookstore.domain.repository.PublisherRepository;
import com.fpmislata.bookstore.domain.service.PublisherService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public Optional<Publisher> findById(Long id) {
        return publisherRepository.findById(id);
    }
}
