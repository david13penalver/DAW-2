package com.fpmislata.bookstore.domain.usecase.album.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.model.Album;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.service.AlbumService;
import com.fpmislata.bookstore.domain.usecase.album.AlbumGetAllUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class AlbumGetAllUseCaseImpl implements AlbumGetAllUseCase {

    private final AlbumService albumService;

    @Override
    public ListWithCount<Album> execute(int i, int pageSize) {
        return albumService.findAll(i, pageSize);
    }
}
