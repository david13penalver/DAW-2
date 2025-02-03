package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Album;
import com.fpmislata.bookstore.domain.model.ListWithCount;

public interface AlbumService {
    ListWithCount<Album> findAll(int i, int pageSize);
}
