package com.fpmislata.bookstore.domain.model;

import com.fpmislata.bookstore.common.locale.LanguageUtils;
import com.fpmislata.bookstore.common.validation.ValidYear;
import jakarta.annotation.Nullable;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private Long id;
    @Nullable
    private String name;
    private String nationality;
    private String biographyEs;
    private String biographyEn;
    @Min(value = -1880, message = "El año de nacimiento debe ser mayor o igual a 1880")
    private Integer birthYear;
    @ValidYear
    private Integer deathYear;

    public String getBiography(){
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return biographyEn;
        }
        return biographyEs;
    }

    public void setBirthYear(int birthYear) {
        if (this.birthYear != null && this.deathYear!= null && this.birthYear > this.deathYear) {
            throw new ValidationException("El año de nacimiento no puede ser mayor que el año de defunción");
        }
        this.birthYear = birthYear;
    }

    public void setDeathYear(int birthYear) {
        if (this.birthYear != null && this.deathYear!= null && this.birthYear > this.deathYear) {
            throw new ValidationException("El año de nacimiento no puede ser mayor que el año de defunción");
        }
        this.birthYear = birthYear;
    }
}
