package com.bs24.demo.domain.model;

import com.bs24.demo.persistence.dao.db.entity.ExerciseJPA;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    private int sessionId;
    private String name;
    private String description;
    private String dateCreation;
    private User user;
}
