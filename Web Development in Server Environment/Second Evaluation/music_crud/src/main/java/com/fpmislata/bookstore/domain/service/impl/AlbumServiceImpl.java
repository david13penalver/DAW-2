package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.Album;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.repository.AlbumRepository;
import com.fpmislata.bookstore.domain.service.AlbumService;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Override
    public ListWithCount<Album> findAll(int i, int pageSize) {
        return albumRepository.findAll(i, pageSize);
    }
}
