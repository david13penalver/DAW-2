package com.fpmislata.bookstore.persistence.dao.db.jpa;

import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.model.Publisher;
import com.fpmislata.bookstore.persistence.dao.db.GenericDaoDb;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.PublisherJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@AllArgsConstructor
public class PublisherDaoJpa implements GenericDaoDb<Publisher> {

    private final PublisherJpaRepository publisherJpaRepository;

    @Override
    public List<Publisher> getAll() {
        return List.of();
    }

    @Override
    public ListWithCount<Publisher> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Publisher> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Publisher publisher) {
        return 0;
    }

    @Override
    public void update(Publisher publisher) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return null;
    }
}
