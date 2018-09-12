package ru.ezikvice.springotus.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.ezikvice.springotus.domain.Question;
import ru.ezikvice.springotus.domain.UserExamination;
import ru.ezikvice.springotus.service.LoadService;
import ru.ezikvice.springotus.service.QAService;

import java.util.Map;

@ShellComponent
public class Commands {
    private final LoadService loadService;
    private final QAService qaService;
    private String name;

    @Autowired
    public Commands(LoadService loadService, QAService qaService) {
        this.loadService = loadService;
        this.qaService = qaService;
    }

    @ShellMethod(value = "1. get name", key={"getname", "name", "n"})
    public void getName(@ShellOption String name) {
        this.name = name;
    }

    @ShellMethod(value="2. examine. ", key={"test", "examine", "exam","x"})
    public void examine() {
        Map<Integer, Question> questionMap = loadService.loadQuestions();
        UserExamination exam = qaService.examine(name, questionMap);
        qaService.printResult(exam);
    }

}
