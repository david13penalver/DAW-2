package com.fpmislata.bookstore.domain.model;

import com.fpmislata.bookstore.common.validation.ValidYear;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Race {

    private Long id;
    private String name;
    private String date;
    private String location;
//    @ValidYear
//    @NotNull
//    private Integer year_paraValidarSolo;
//    private Integer yearRandom_paraValidarSolo = 2021;
//
//    public void setYear_paraValidarSolo(Integer year_paraValidarSolo) {
//        if (this.yearRandom_paraValidarSolo != null && this.yearRandom_paraValidarSolo > year_paraValidarSolo) {
//            throw new ValidationException("El año de la carrera tiene que ser medianamente actual.");
//        }
//        this.year_paraValidarSolo = year_paraValidarSolo;
//    }
}
