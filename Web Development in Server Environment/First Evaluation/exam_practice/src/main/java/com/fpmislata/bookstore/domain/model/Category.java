package com.fpmislata.bookstore.domain.model;

import com.fpmislata.bookstore.common.locale.LanguageUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private Long id;
    private String nameEs;
    private String nameEn;
    private String slug;

    public String getName(){
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return nameEn;
        }
        return nameEs;
    }
}
