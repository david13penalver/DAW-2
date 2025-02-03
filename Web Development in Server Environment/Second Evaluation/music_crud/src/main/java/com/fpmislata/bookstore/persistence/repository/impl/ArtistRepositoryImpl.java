package com.fpmislata.bookstore.persistence.repository.impl;

import com.fpmislata.bookstore.domain.repository.ArtistRepository;
import com.fpmislata.bookstore.persistence.dao.db.ArtistDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistRepositoryImpl implements ArtistRepository {

    private final ArtistDaoDb artistDaoDb;
}
