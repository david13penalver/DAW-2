package com.fpmislata.bookstore.domain.usecase.album;

import com.fpmislata.bookstore.domain.model.Album;
import com.fpmislata.bookstore.domain.model.ListWithCount;

public interface AlbumGetAllUseCase {
    ListWithCount<Album> execute(int i, int pageSize);
}
