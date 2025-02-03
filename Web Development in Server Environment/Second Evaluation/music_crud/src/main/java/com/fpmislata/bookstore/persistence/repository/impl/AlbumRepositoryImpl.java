package com.fpmislata.bookstore.persistence.repository.impl;

import com.fpmislata.bookstore.domain.model.Album;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.repository.AlbumRepository;
import com.fpmislata.bookstore.persistence.dao.db.AlbumDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AlbumRepositoryImpl implements AlbumRepository {

    private final AlbumDaoDb albumDaoDb;

    @Override
    public ListWithCount<Album> findAll(int i, int pageSize) {
        return albumDaoDb.getAll(i, pageSize);
    }
}
