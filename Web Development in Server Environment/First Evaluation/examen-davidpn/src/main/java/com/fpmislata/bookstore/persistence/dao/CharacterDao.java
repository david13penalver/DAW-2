package com.fpmislata.bookstore.persistence.dao;

import com.fpmislata.bookstore.domain.model.CharacterComic;

import java.util.List;

public interface CharacterDao {
    List<CharacterComic> getAll();
}
