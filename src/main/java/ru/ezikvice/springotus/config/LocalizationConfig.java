package ru.ezikvice.springotus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class LocalizationConfig {

    @Bean
    ResourceBundle resourceBundle() {

       //TODO: How to get locale from resource file appConfigProperties?
        Locale loc = new Locale("ru", "RU");
        return ResourceBundle.getBundle("l10n", loc);
    }
}
