package ru.ezikvice.springotus.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.ezikvice.springotus.domain.Question;
import ru.ezikvice.springotus.domain.UserExamination;
import ru.ezikvice.springotus.service.LoadService;
import ru.ezikvice.springotus.service.QAService;

import java.util.Map;

@ShellComponent
public class Commands {
    private final LoadService loadService;
    private final QAService qaService;

    @Autowired
    public Commands(LoadService loadService, QAService qaService) {
        this.loadService = loadService;
        this.qaService = qaService;
    }


    @ShellMethod(value="examine. please", key={"test", "examine", "exam","x"})
    public void examine() {
        Map<Integer, Question> questionMap = loadService.loadQuestions();
        UserExamination exam = qaService.examine(questionMap);
        qaService.printResult(exam);
    }

}
