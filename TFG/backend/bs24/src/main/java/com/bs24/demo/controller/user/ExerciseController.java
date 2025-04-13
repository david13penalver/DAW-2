package com.bs24.demo.controller.user;

import com.bs24.demo.common.config.PropertiesConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.path}/exercises")
public class ExerciseController {

    // public static final String URL = "/exercises";
    private final String defaultPageSize = PropertiesConfig.getSetting("app.pageSize.default");
}
