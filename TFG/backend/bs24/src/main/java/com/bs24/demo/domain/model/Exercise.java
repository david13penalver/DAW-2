package com.bs24.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    private int exerciseId;
    private String name;
    private String description;
    private String imageURL;
    private String videoURL;
    private Boolean isGlobal;
    private ExerciseType exerciseType;
    private ExerciseSubtype exerciseSubtype;
}
