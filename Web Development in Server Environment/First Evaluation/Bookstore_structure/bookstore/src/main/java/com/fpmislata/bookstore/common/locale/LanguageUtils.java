package com.fpmislata.bookstore.common.locale;

import java.util.Locale;

public class LanguageUtils {

    private static final ThreadLocal<Locale> currentLocale = new ThreadLocal<>();

    public static void setCurrentLocale(Locale locale) {
        currentLocale.set(locale); // Establece el idioma actual en el contexto de hilo
    }

    public static String getCurrentLanguage() {
        Locale locale = currentLocale.get(); // Obtiene el idioma actual
        return locale != null ? locale.getLanguage() : locale.getDefault().getLanguage();
        // Se pone "locale != null" para que devuelva el actual. Si es null, devuelve el idioma por defecto.
    }
}
