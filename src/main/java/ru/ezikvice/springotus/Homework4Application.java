package ru.ezikvice.springotus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.ezikvice.springotus.domain.Question;
import ru.ezikvice.springotus.domain.UserExamination;
import ru.ezikvice.springotus.service.LoadService;
import ru.ezikvice.springotus.service.QAService;

import java.util.Map;

@SpringBootApplication
public class Homework4Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework4Application.class);
    }
}
