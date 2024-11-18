package com.fpmislata.bookstore.domain.repository;

import com.fpmislata.bookstore.domain.model.CharacterComic;

import java.util.List;

public interface CharacterRepository {
    List<CharacterComic> getAll();
}
