package com.bs24.demo.controller.user.webmodel;

public record ExerciseDetail(
        int exerciseId,
        String name,
        String description,
        String imageURL,
        String videoURL,
        Boolean isGlobal,
        ExerciseTypeCollection exerciseType,
        ExerciseSubtypeCollection exerciseSubtype
) {
}
