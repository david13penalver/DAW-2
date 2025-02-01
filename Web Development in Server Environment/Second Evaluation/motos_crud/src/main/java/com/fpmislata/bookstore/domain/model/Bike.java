package com.fpmislata.bookstore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {

    private Long id;
    private String brand;
    private String model;
    private Long cylinder_capacity;
    private Rider rider;
}
