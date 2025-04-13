package com.bs24.demo.controller.user.webmodel;

public record ExerciseDetail(
        //String id,
        String name,
        String imageURL,
        ExerciseTypeCollection exerciseType,
        ExerciseSubtypeCollection exerciseSubtype
) {
}
