package com.bs24.demo.controller.user;

import com.bs24.demo.common.config.PropertiesConfig;
import com.bs24.demo.controller.common.PaginatedResponse;
import com.bs24.demo.controller.user.webmodel.*;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.usecase.exercise.ExerciseFindByIdUseCase;
import com.bs24.demo.domain.usecase.exercise.ExerciseInsertUseCase;
import com.bs24.demo.domain.usecase.session.SessionFindByIdUseCase;
import com.bs24.demo.domain.usecase.session.SessionGetAllUseCase;
import com.bs24.demo.domain.usecase.session.SessionInsertUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.path}/sessions")
public class SessionController {

    public static final String URL = "/api/exercises";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final SessionGetAllUseCase sessionGetAllUseCase;
    private final SessionFindByIdUseCase sessionFindByIdUseCase;
    private final SessionInsertUseCase sessionInsertUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<SessionCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {

        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;
        ListWithCount<Session> sessionListWithCount = sessionGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<SessionCollection> response = new PaginatedResponse<>(
                sessionListWithCount
                        .getList()
                        .stream()
                        .map(SessionCollectionMapper.INSTANCE::toSessionCollection)
                        .toList(),
                sessionListWithCount.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionDetail> findById(@PathVariable int id) {
        SessionDetail sessionDetail = SessionDetailMapper.INSTANCE.toSessionDetail(sessionFindByIdUseCase.execute(id));
        return new ResponseEntity<>(sessionDetail, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Session session) {
        sessionInsertUseCase.execute(session);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
