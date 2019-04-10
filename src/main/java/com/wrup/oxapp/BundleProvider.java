package com.wrup.oxapp;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author Wiktor Rup
 */
class BundleProvider {

    //TODO: don't we need object Language?
    private String language;

    BundleProvider(String language) {
        this.language = language;

    }

    String getMessage(String key) {
        if (language.equals("pl"))
            return ResourceBundle.getBundle("OX", new Locale(language, "PL")).getString(key);
        /* TODO: where is code extensibility? -->
        else if(language.equals("fr")
            ...
        else if(language.equals("Wiktor chyba nie mial czasu pomyslec nad jezykami :p")
            ...
         */
        else return ResourceBundle.getBundle("OX", new Locale(language, "EN")).getString(key);
    }

    //TODO: auto-generated?
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BundleProvider that = (BundleProvider) o;
        return Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language);
    }
}
