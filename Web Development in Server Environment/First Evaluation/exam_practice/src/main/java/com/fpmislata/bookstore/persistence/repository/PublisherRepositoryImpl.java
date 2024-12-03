package com.fpmislata.bookstore.persistence.repository;

import com.fpmislata.bookstore.domain.model.Publisher;
import com.fpmislata.bookstore.domain.repository.PublisherRepository;
import com.fpmislata.bookstore.domain.service.PublisherService;
import com.fpmislata.bookstore.persistence.dao.db.PublisherDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PublisherRepositoryImpl implements PublisherRepository {

    private final PublisherDaoDb publisherDaoDb;
    @Override
    public Optional<Publisher> findById(long idPublisher) {
        return publisherDaoDb.findById(idPublisher);
    }
}
