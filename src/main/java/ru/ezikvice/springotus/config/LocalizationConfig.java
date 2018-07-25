package ru.ezikvice.springotus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class LocalizationConfig {

    private String locale;

    public LocalizationConfig(@Value("${locale}") String locale) {
        this.locale = locale;
    }

    @Bean
    ResourceBundle resourceBundle() {

       //TODO: How to get locale from resource file appConfigProperties?
//        Locale loc = new Locale(locale.toLowerCase(), locale.toUpperCase());
        Locale loc = new Locale("ru", "RU");
        return ResourceBundle.getBundle("l10n", loc);
    }
}
