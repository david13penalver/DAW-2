package com.fpmislata.bookstore.domain.model;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {

    private Long id;
    @NotNull
    private String brand;
    private String model;
    @Min(value = 500, message = "No es una MotoGP")
    private Long cylinder_capacity;
    private Rider rider;
}
