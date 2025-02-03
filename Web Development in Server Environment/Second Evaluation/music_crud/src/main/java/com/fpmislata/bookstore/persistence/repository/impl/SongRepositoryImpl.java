package com.fpmislata.bookstore.persistence.repository.impl;

import com.fpmislata.bookstore.domain.repository.SongRepository;
import com.fpmislata.bookstore.persistence.dao.db.SongDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SongRepositoryImpl implements SongRepository {

    private final SongDaoDb songDaoDb;
}
