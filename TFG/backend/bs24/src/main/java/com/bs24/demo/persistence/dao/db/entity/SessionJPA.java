package com.bs24.demo.persistence.dao.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sessions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private int sessionId;
    private String name;
    private String description;
    @Column(name = "date_creation")
    private String dateCreation;
    private UserJPA user;
    // TODO: Es la tabla que se enlaza con la tabla de ejercicios en una tabla intermedia
}
