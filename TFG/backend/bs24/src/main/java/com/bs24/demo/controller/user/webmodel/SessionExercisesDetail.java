package com.bs24.demo.controller.user.webmodel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public record SessionExercisesDetail(
        int sessionExercisesId,
        int numSets,
        int numReps,
        int restSeconds,
        SessionDetail session,
        ExerciseDetail exercise
) {
}
