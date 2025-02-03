package com.fpmislata.bookstore.controller.user;

import com.fpmislata.bookstore.common.config.PropertiesConfig;
import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import com.fpmislata.bookstore.domain.model.Bike;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.usecase.bike.BikeGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bikes")
@RequiredArgsConstructor
public class BikeController {

    public static final String URL = PropertiesConfig.getSetting("app.api.path") + "/bikes";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final BikeGetAllUseCase bikeGetAllUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<Bike>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;
        ListWithCount<Bike> bikeListWithCount = bikeGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<Bike> response = new PaginatedResponse<>(
                bikeListWithCount
                        .getList()
                        .stream()
                        .toList(),
                bikeListWithCount.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
