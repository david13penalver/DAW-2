package com.fpmislata.bookstore.controller.user;

import com.fpmislata.bookstore.domain.user.model.Book;
import com.fpmislata.bookstore.domain.user.model.Genre;
import com.fpmislata.bookstore.domain.user.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public List<Genre> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}/books")
    public List<Book> getBooksByGenre(int id) {
        return genreService.getBooksByGenre(id);
    }

}
