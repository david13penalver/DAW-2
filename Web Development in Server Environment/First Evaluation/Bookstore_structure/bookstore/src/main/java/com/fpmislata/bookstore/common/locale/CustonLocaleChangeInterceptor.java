package com.fpmislata.bookstore.common.locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

public class CustonLocaleChangeInterceptor extends LocaleChangeInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        String lang = request.getHeader("Accept-Language"); // Obtiene el valor de la cabecera
        Locale locale = lang != null ? Locale.forLanguageTag(lang) : Locale.getDefault();

        LanguageUtils.setCurrentLocale(locale); // Establece el idioma actual

        return super.preHandle(request, response, handler); // Llama al método preHandle de la clase padre
    }
}
