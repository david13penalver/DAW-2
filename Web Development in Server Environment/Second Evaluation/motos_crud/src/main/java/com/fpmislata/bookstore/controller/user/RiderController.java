package com.fpmislata.bookstore.controller.user;

import com.fpmislata.bookstore.common.config.PropertiesConfig;
import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import com.fpmislata.bookstore.domain.model.Bike;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.model.Rider;
import com.fpmislata.bookstore.domain.usecase.bike.BikeGetAllUseCase;
import com.fpmislata.bookstore.persistence.dao.db.jpa.entity.RiderJPA;
import com.fpmislata.bookstore.persistence.dao.db.jpa.mapper.RiderJPAMapper;
import com.fpmislata.bookstore.persistence.dao.db.jpa.repository.RiderJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/riders")
@RequiredArgsConstructor
public class RiderController {
    public static final String URL = PropertiesConfig.getSetting("app.api.path") + "/bikes";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final RiderJPARepository riderJPARepository;

    @GetMapping
    public ResponseEntity<PaginatedResponse<Rider>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;

        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<RiderJPA> riderJPAPage = riderJPARepository.findAll(pageable);
        ListWithCount<Rider> bikeListWithCount = new ListWithCount<>(
                riderJPAPage
                        .stream()
                        .map(RiderJPAMapper.INSTANCE::toRider)
                        .toList(),
                riderJPAPage.getNumberOfElements()
        );
        PaginatedResponse<Rider> response = new PaginatedResponse<>(
                bikeListWithCount
                        .getList()
                        .stream()
                        .toList(),
                bikeListWithCount.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
