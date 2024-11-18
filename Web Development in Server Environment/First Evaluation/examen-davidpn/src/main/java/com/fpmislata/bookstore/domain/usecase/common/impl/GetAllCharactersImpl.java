package com.fpmislata.bookstore.domain.usecase.common.impl;

import com.fpmislata.bookstore.common.annotation.DomainTransactional;
import com.fpmislata.bookstore.common.annotation.DomainUseCase;
import com.fpmislata.bookstore.domain.model.CharacterComic;
import com.fpmislata.bookstore.domain.service.CharacterComicService;
import com.fpmislata.bookstore.domain.usecase.common.GetAllCharacters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
// @DomainUseCase pongo @Component porque tengo que rellenar esta clase aun
@DomainTransactional
@Component

public class GetAllCharactersImpl implements GetAllCharacters {

    private final CharacterComicService characterComicService;

    @Override
    public List<CharacterComic> execute() {
        return characterComicService.getAll();
    }
}
