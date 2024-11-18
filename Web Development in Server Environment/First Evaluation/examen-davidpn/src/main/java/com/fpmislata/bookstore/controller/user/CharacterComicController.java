package com.fpmislata.bookstore.controller.user;


import com.fpmislata.bookstore.domain.model.CharacterComic;
import com.fpmislata.bookstore.domain.usecase.common.GetAllCharacters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CharacterComicController.URL)
//@RequestMapping("/characters")
@RequiredArgsConstructor
public class CharacterComicController {

    public static final String URL = "/characters";
    private final GetAllCharacters getAllCharacters;

    @GetMapping
    public ResponseEntity<List<CharacterComic>> getAll() {
        List<CharacterComic> characterComics = getAllCharacters.execute();
        return new ResponseEntity<>(characterComics, HttpStatus.OK);
    }
}
