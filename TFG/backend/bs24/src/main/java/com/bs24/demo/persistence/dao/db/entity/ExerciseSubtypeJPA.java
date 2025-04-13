package com.bs24.demo.persistence.dao.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercise_subtypes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseSubtypeJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subtype_id")
    private int exerciseTypeId;
    private String name;
}
