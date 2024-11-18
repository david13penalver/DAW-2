package com.fpmislata.bookstore.persistence.repository.impl;

import com.fpmislata.bookstore.domain.model.CharacterComic;
import com.fpmislata.bookstore.domain.repository.CharacterRepository;
import com.fpmislata.bookstore.persistence.dao.CharacterDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    private final CharacterDao characterDao;

    @Override
    public List<CharacterComic> getAll() {
        return characterDao.getAll();
    }
}
