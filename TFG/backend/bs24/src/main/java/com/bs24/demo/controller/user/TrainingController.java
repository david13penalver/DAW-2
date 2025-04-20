package com.bs24.demo.controller.user;

import com.bs24.demo.common.config.PropertiesConfig;
import com.bs24.demo.controller.common.PaginatedResponse;
import com.bs24.demo.controller.user.webmodel.*;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Session;
import com.bs24.demo.domain.model.Training;
import com.bs24.demo.domain.usecase.session.SessionFindByIdUseCase;
import com.bs24.demo.domain.usecase.session.SessionGetAllUseCase;
import com.bs24.demo.domain.usecase.session.SessionInsertUseCase;
import com.bs24.demo.domain.usecase.training.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.path}/trainings")
public class TrainingController {

    public static final String URL = "/api/trainings";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final TrainingGetAllUseCase trainingGetAllUseCase;
    private final TrainingFindByIdUseCase trainingFindByIdUseCase;
    private final TrainingInsertUseCase trainingInsertUseCase;
    private final TrainingUpdateUseCase trainingUpdateUseCase;
    private final TrainingDeleteUseCase trainingDeleteUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<TrainingCollecion>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {

        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;
        ListWithCount<Training> trainingListWithCount = trainingGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<TrainingCollecion> response = new PaginatedResponse<>(
                trainingListWithCount
                        .getList()
                        .stream()
                        .map(TrainingCollectionMapper.INSTANCE::toTrainingCollection)
                        .toList(),
                trainingListWithCount.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingDetail> findById(@PathVariable int id) {
        TrainingDetail trainingDetail = TrainingDetailMapper.INSTANCE.toTrainingDetail(trainingFindByIdUseCase.execute(id));
        return new ResponseEntity<>(trainingDetail, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Training training) {
        trainingInsertUseCase.execute(training);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Training training) {
        training.setTrainingId(id);
        trainingUpdateUseCase.execute(training);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        trainingDeleteUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
