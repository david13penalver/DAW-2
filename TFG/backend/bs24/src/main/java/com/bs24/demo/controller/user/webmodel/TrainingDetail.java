package com.bs24.demo.controller.user.webmodel;

import java.util.List;

public record TrainingDetail(
        int trainingId,
        String name,
        int trainingDurationSeconds,
        String dateCreation,
        UserDetail user,
        List<SessionDetail> sessions
) {
}
