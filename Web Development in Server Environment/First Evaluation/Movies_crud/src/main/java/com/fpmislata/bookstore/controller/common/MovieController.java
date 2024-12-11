package com.fpmislata.bookstore.controller.common;

import com.fpmislata.bookstore.controller.common.webmodel.book.MovieCollection;
import com.fpmislata.bookstore.controller.common.webmodel.book.MovieMapper;
import com.fpmislata.bookstore.domain.model.Movie;
import com.fpmislata.bookstore.domain.usecase.common.MovieGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(MovieController.URL)
public class MovieController {

    // REST
    public static final String URL = "/api/movies";

    @Value("${app.base.url}")
    private String baseURL;

    @Value("${app.pageSize.default}")
    private String defaulPageSize;

    // Use cases implementations
    private final MovieGetAllUseCase movieGetAllUseCase;
    //private final MovieCountUseCase movieCountUseCase;

    // SELECT methods

    @GetMapping
    public ResponseEntity<PaginatedResponse<MovieCollection>> getAll(
        Integer page, Integer size
    ) {
        List<MovieCollection> movies = movieGetAllUseCase.
                execute(page, size)
                .stream()
                .map(movie -> MovieMapper.INSTANCE.toMovieCollection(movie))
                .toList();

        int total = 100; //movieCountUseCase.execute();

        PaginatedResponse<MovieCollection> response = new PaginatedResponse<>(movies, total, page, size, baseURL + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
