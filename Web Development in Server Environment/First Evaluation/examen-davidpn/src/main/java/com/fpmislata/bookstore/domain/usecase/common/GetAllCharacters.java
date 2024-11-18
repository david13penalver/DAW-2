package com.fpmislata.bookstore.domain.usecase.common;

import com.fpmislata.bookstore.domain.model.CharacterComic;

import java.util.List;

public interface GetAllCharacters {
    List<CharacterComic> execute();
}
