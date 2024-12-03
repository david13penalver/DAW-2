package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Publisher;

import java.util.Optional;

public interface PublisherRepository {
    Optional<Publisher> findById(long idPublisher);
}
