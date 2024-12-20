package com.fpmislata.bookstore.domain.service;

import com.fpmislata.bookstore.domain.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getByIdBook(long idBook);

    List<Author> findAllById(List<Author> authors);
}
