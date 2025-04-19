package com.bs24.demo.controller.user;

import com.bs24.demo.common.config.PropertiesConfig;
import com.bs24.demo.controller.common.PaginatedResponse;
import com.bs24.demo.controller.user.webmodel.ExerciseCollection;
import com.bs24.demo.controller.user.webmodel.ExerciseCollectionMapper;
import com.bs24.demo.controller.user.webmodel.ExerciseDetail;
import com.bs24.demo.controller.user.webmodel.ExerciseDetailMapper;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.usecase.exercise.ExerciseFindByIdUseCase;
import com.bs24.demo.domain.usecase.exercise.ExerciseGetAllUseCase;
import com.bs24.demo.domain.usecase.exercise.ExerciseInsertUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.path}/exercises")
public class ExerciseController {

    public static final String URL = "/exercises";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final ExerciseGetAllUseCase exerciseGetAllUseCase;
    private final ExerciseFindByIdUseCase exerciseFindByIdUseCase;
    private final ExerciseInsertUseCase exerciseInsertUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<ExerciseCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {

        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;
        ListWithCount<Exercise> exerciseListWithCount = exerciseGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<ExerciseCollection> response = new PaginatedResponse<>(
                exerciseListWithCount
                        .getList()
                        .stream()
                        .map(ExerciseCollectionMapper.INSTANCE::toExerciseCollection)
                        .toList(),
                exerciseListWithCount.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseDetail> findById(@PathVariable int id) {
        ExerciseDetail exerciseDetail = ExerciseDetailMapper.INSTANCE.toExerciseDetail(exerciseFindByIdUseCase.execute(id));
        return new ResponseEntity<>(exerciseDetail, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Exercise exercise) {
        exerciseInsertUseCase.execute(exercise);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
