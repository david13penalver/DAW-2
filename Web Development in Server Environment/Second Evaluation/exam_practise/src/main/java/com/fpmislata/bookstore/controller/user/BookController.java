package com.fpmislata.bookstore.controller.user;

import com.fpmislata.bookstore.common.config.PropertiesConfig;
import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import com.fpmislata.bookstore.controller.user.webmodel.book.BookCollection;
import com.fpmislata.bookstore.controller.user.webmodel.book.BookMapper;
import com.fpmislata.bookstore.domain.model.Book;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.usecase.book.BookGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    public static final String URL = PropertiesConfig.getSetting("app.api.path") + "/books";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final BookGetAllUseCase bookGetAllUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {

        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;
        ListWithCount<Book> bookList = bookGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(
                bookList
                        .getList()
                        .stream()
                        .map(BookMapper.INSTANCE::toBookCollection)
                        .toList(),
                bookList.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
