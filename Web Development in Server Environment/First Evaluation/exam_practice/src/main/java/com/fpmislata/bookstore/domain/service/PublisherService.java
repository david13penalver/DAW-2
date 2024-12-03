package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Publisher;

import java.util.Optional;

public interface PublisherService {
    Optional<Publisher> findById(long idPublisher);
}
