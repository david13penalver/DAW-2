package com.bs24.demo.controller.user;

import com.bs24.demo.common.config.PropertiesConfig;
import com.bs24.demo.controller.user.webmodel.ExerciseDetail;
import com.bs24.demo.controller.user.webmodel.ExerciseDetailMapper;
import com.bs24.demo.controller.user.webmodel.UserDetail;
import com.bs24.demo.controller.user.webmodel.UserDetailMapper;
import com.bs24.demo.domain.model.User;
import com.bs24.demo.domain.usecase.exercise.ExerciseFindByIdUseCase;
import com.bs24.demo.domain.usecase.user.UserFindByIdUseCase;
import com.bs24.demo.domain.usecase.user.UserInsertUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.path}/users")
public class UserController {

    public static final String URL = "/api/users";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");

    private final UserFindByIdUseCase userFindByIdUseCase;
    private final UserInsertUseCase userInsertUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<UserDetail> findById(@PathVariable int id) {
        UserDetail userDetail = UserDetailMapper.INSTANCE.toUserDetail(userFindByIdUseCase.execute(id));
        return new ResponseEntity<>(userDetail, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody User user) {
        userInsertUseCase.execute(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
