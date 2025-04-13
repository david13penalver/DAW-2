package com.bs24.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userId;
    private String name;
    private String email;
    private String password;
    private String dateRegister;
}
