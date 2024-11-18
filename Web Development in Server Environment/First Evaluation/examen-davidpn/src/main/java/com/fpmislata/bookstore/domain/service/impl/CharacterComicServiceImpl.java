package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.domain.model.CharacterComic;
import com.fpmislata.bookstore.domain.repository.CharacterRepository;
import com.fpmislata.bookstore.domain.service.CharacterComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
//@DomainService pongo @Component porque tengo que rellenar esta clase aun
@Component
public class CharacterComicServiceImpl implements CharacterComicService {

    private final CharacterRepository characterRepository;

    @Override
    public List<CharacterComic> getAll() {
        return characterRepository.getAll();
    }
}
