package com.bs24.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionExercises {

    private int sessionExercisesId;
    private int numSets;
    private int numReps;
    private int restSeconds;
    private Session session;
    private Exercise exercise;
}
