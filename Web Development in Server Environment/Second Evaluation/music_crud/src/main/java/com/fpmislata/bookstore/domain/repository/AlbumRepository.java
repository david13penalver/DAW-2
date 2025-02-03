package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.Album;
import com.fpmislata.bookstore.domain.model.ListWithCount;

public interface AlbumRepository {
    ListWithCount<Album> findAll(int i, int pageSize);
}
