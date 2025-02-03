package com.fpmislata.bookstore.controller.user;

import com.fpmislata.bookstore.common.config.PropertiesConfig;
import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import com.fpmislata.bookstore.domain.model.Album;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.usecase.album.AlbumGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {

    public static final String URL = PropertiesConfig.getSetting("app.api.path") + "/albums";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final AlbumGetAllUseCase albumGetAllUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<Album>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {

        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;
        ListWithCount<Album> bookList = albumGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<Album> response = new PaginatedResponse<>(
                bookList
                        .getList()
                        .stream()
                        .toList(),
                bookList.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
