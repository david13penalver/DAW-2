package com.bs24.demo.controller.user.webmodel;

public record ExerciseCollection(
        //String id,
        String name,
        String imageURL,
        ExerciseTypeCollection exerciseType,
        ExerciseSubtypeCollection exerciseSubtype
) {
}
