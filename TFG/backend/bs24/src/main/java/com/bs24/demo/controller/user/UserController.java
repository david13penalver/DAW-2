package com.bs24.demo.controller.user;

import com.bs24.demo.common.config.PropertiesConfig;
import com.bs24.demo.controller.common.PaginatedResponse;
import com.bs24.demo.controller.user.webmodel.*;
import com.bs24.demo.domain.model.Exercise;
import com.bs24.demo.domain.model.ListWithCount;
import com.bs24.demo.domain.model.Training;
import com.bs24.demo.domain.model.User;
import com.bs24.demo.domain.usecase.exercise.ExerciseFindByIdUseCase;
import com.bs24.demo.domain.usecase.user.*;
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

    private final UserGetAllUseCase userGetAllUseCase;
    private final UserFindByIdUseCase userFindByIdUseCase;
    private final UserInsertUseCase userInsertUseCase;
    private final UserUpdateUseCase userUpdateUseCase;
    private final UserDeleteUseCase userDeleteUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<UserDetail>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {

        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        String baseUrl = PropertiesConfig.getSetting("app.base.url") + URL;
        ListWithCount<User> userListWithCount = userGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<UserDetail> response = new PaginatedResponse<>(
                userListWithCount
                        .getList()
                        .stream()
                        .map(UserDetailMapper.INSTANCE::toUserDetail)
                        .toList(),
                userListWithCount.getCount(), page, pageSize, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody User user) {
        user.setUserId(id);
        userUpdateUseCase.execute(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        userDeleteUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
