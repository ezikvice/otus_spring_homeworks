package ru.ezikvice.springotus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class LocalizationConfig {

    private final String locale;

    public LocalizationConfig(@Value("${lang}") String lang) {
        this.locale = lang;
    }


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    Locale currentLocale() {
        return Locale.forLanguageTag(locale);
    }
}
