package com.bs24.demo.controller.user.webmodel;

public record TrainingDetail(
        int trainingId,
        String name,
        int trainingDurationSeconds,
        String dateCreation,
        UserDetail user,
        SessionDetail session
) {
}
