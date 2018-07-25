package ru.ezikvice.springotus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.ezikvice.springotus.domain.Question;
import ru.ezikvice.springotus.domain.UserExamination;
import ru.ezikvice.springotus.service.LoadService;
import ru.ezikvice.springotus.service.QAService;

import java.util.Map;

@SpringBootApplication
public class Homework3Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework3Application.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Homework3Application.class);
        QAService service = context.getBean(QAService.class);
        LoadService loadService = context.getBean(LoadService.class);

        Map<Integer, Question> questionMap = loadService.loadQuestions();
        UserExamination exam = service.examine(questionMap);
        service.printResult(exam);

    }
}
