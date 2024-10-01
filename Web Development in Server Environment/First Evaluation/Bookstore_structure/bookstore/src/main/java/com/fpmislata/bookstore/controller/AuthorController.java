package com.fpmislata.bookstore.controller;

import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    @Autowired
    private final AuthorService authorService;

    @GetMapping
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Author> findById(@PathVariable int id) {
        return authorService.findById(id);
    }

    @GetMapping("/{id}/books")
    public List<Book> getBooksByAuthor(@PathVariable int id) {
        return authorService.getBooksByAuthor(id);
    }
}
