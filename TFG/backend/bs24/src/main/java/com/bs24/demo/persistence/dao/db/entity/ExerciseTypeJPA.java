package com.bs24.demo.persistence.dao.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercise_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseTypeJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int exerciseTypeId;
    private String name;
}
