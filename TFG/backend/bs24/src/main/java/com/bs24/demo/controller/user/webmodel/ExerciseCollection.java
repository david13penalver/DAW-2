package com.bs24.demo.controller.user.webmodel;

public record ExerciseCollection(
        int exerciseId,
        String name,
        String imageURL,
        ExerciseTypeCollection exerciseType,
        ExerciseSubtypeCollection exerciseSubtype
) {
}
