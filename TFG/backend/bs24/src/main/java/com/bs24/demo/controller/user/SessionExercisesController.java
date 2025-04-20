package com.bs24.demo.controller.user;

import com.bs24.demo.common.config.PropertiesConfig;
import com.bs24.demo.controller.common.PaginatedResponse;
import com.bs24.demo.controller.user.webmodel.*;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.SessionExercises;
import com.bs24.demo.domain.usecase.session.SessionFindByIdUseCase;
import com.bs24.demo.domain.usecase.session.SessionGetAllUseCase;
import com.bs24.demo.domain.usecase.session.SessionInsertUseCase;
import com.bs24.demo.domain.usecase.sessionexercises.session.SessionExercisesFindByIdUseCase;
import com.bs24.demo.domain.usecase.sessionexercises.session.SessionExercisesFindBySessionId;
import com.bs24.demo.domain.usecase.sessionexercises.session.SessionExercisesGetAllUseCase;
import com.bs24.demo.domain.usecase.sessionexercises.session.SessionExercisesInsertUseCase;
import com.bs24.demo.domain.usecase.sessionexercises.session.impl.SessionExercisesGetAllUseCaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.path}/sessionsexercises")
public class SessionExercisesController {

    public static final String URL = "/api/sessionsexercises";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final SessionExercisesGetAllUseCase sessionExercisesGetAllUseCase;
    private final SessionExercisesFindByIdUseCase sessionExercisesFindByIdUseCase;
    private final SessionExercisesFindBySessionId sessionExercisesFindBySessionId;
    private final SessionExercisesInsertUseCase sessionExercisesInsertUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<SessionExercisesDetail>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {

        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;
        ListWithCount<SessionExercises> sessionExercisesListWithCount = sessionExercisesGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<SessionExercisesDetail> response = new PaginatedResponse<>(
                sessionExercisesListWithCount
                        .getList()
                        .stream()
                        .map(SessionExercisesDetailMapper.INSTANCE::toSessionExercisesDetail)
                        .toList(),
                sessionExercisesListWithCount.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionExercisesDetail> findById(@PathVariable int id) {
        SessionExercisesDetail sessionExercisesDetail = SessionExercisesDetailMapper.INSTANCE.toSessionExercisesDetail(sessionExercisesFindByIdUseCase.execute(id));
        return new ResponseEntity<>(sessionExercisesDetail, HttpStatus.OK);
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<PaginatedResponse<SessionExercisesDetail>> getAllBySessionId(
            @PathVariable int sessionId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {

        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;
        ListWithCount<SessionExercises> sessionExercisesListWithCount = sessionExercisesFindBySessionId.execute(sessionId, page - 1, pageSize);
        PaginatedResponse<SessionExercisesDetail> response = new PaginatedResponse<>(
                sessionExercisesListWithCount
                        .getList()
                        .stream()
                        .map(SessionExercisesDetailMapper.INSTANCE::toSessionExercisesDetail)
                        .toList(),
                sessionExercisesListWithCount.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody SessionExercises sessionExercises) {
        sessionExercisesInsertUseCase.execute(sessionExercises);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
