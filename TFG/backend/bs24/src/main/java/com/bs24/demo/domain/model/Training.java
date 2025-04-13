package com.bs24.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Training {

    private int trainingId;
    private String name;
    private int trainingDurationSeconds;
    private String dateCreation;
    private User user;
    private List<Session> sessions;
}
