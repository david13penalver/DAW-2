package com.fpmislata.bookstore.controller.user;

import com.fpmislata.bookstore.common.config.PropertiesConfig;
import com.fpmislata.bookstore.controller.common.PaginatedResponse;
import com.fpmislata.bookstore.domain.model.ListWithCount;
import com.fpmislata.bookstore.domain.model.Race;
import com.fpmislata.bookstore.domain.usecase.race.RaceDeleteRace;
import com.fpmislata.bookstore.domain.usecase.race.RaceGetAllUseCase;
import com.fpmislata.bookstore.domain.usecase.race.RaceFindByIdUseCase;
import com.fpmislata.bookstore.domain.usecase.race.RaceInsertUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/races")
public class RaceController {

    public static final String URL = PropertiesConfig.getSetting("app.api.path") + "/races";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final RaceGetAllUseCase raceGetAllUseCase;
    private final RaceFindByIdUseCase raceFindByIdUseCase;
    private final RaceInsertUseCase raceInsertUseCase;
    private final RaceDeleteRace raceDeleteRace;

    @GetMapping
    public ResponseEntity<PaginatedResponse<Race>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {

        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;
        ListWithCount<Race> raceListWithCount = raceGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<Race> response = new PaginatedResponse<>(
                raceListWithCount
                        .getList()
                        .stream()
                        .toList(),
                raceListWithCount.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Race> findById(@PathVariable Long id) {
        return new ResponseEntity<>(raceFindByIdUseCase.execute(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Race race) {
        raceInsertUseCase.execute(race);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        raceDeleteRace.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
