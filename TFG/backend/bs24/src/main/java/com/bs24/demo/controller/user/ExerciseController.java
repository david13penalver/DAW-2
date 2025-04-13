package com.bs24.demo.controller.user;

import com.bs24.demo.common.config.PropertiesConfig;
import com.bs24.demo.controller.common.PaginatedResponse;
import com.bs24.demo.controller.user.webmodel.ExerciseCollection;
import com.bs24.demo.controller.user.webmodel.ExerciseCollectionMapper;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.usecase.exercise.ExerciseGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.path}/exercises")
public class ExerciseController {

    public static final String URL = "/exercises";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final ExerciseGetAllUseCase exerciseGetAllUseCase;

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
}
