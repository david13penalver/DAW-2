package com.fpmislata.bookstore.domain.service.impl;

import com.fpmislata.bookstore.common.annotation.DomainService;
import com.fpmislata.bookstore.common.exception.ResourceNotFoundException;
import com.fpmislata.bookstore.domain.model.Author;
import com.fpmislata.bookstore.domain.repository.AuthorRepository;
import com.fpmislata.bookstore.domain.service.AuthorService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getByIdBook(long idBook) {
        return authorRepository.getByIdBook(idBook);
    }

    @Override
    public List<Author> findAllById(List<Author> authors) {
        List<Author> foundAuthors =  authorRepository.findAllById(
                authors
                        .stream()
                        .map(Author::getId)
                        .toArray(Long[]::new)
        );
        if(foundAuthors.size() != authors.size()) {
            throw new ResourceNotFoundException("Some authors were not found");
        }
        return foundAuthors;
    }
}
