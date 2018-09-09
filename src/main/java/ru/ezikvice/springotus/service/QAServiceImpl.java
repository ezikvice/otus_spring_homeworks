package ru.ezikvice.springotus.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.domain.Answer;
import ru.ezikvice.springotus.domain.ExaminationQuestion;
import ru.ezikvice.springotus.domain.Question;
import ru.ezikvice.springotus.domain.UserExamination;

import java.util.*;

@Service
public class QAServiceImpl implements QAService {

    private final Scanner scanner = new Scanner(System.in);

    private final MessageSource ms;

    private final Locale curLocale;

    public QAServiceImpl(MessageSource ms, Locale lcl) {
        this.ms = ms;
        this.curLocale = lcl;
    }

    private Answer askQuestion(Question question) {

        System.out.printf("%d. %s%n", question.getId(), question.getText());
        for (Answer answer : question.getAnswers().values()) {
            System.out.printf("%d. %s %n", answer.getId(), answer.getText());
        }
        printLocalized("student.answer");
        Integer userAnswerId;
        Answer userAnswer;
        try {
            userAnswerId = Integer.parseInt(scanner.next());
            userAnswer = question.getAnswerById(userAnswerId);
            if (userAnswer == null) {
                printLocalized("error.answer.not.found");
                userAnswer = askQuestion(question);
            }
        } catch (NumberFormatException e) {
            printLocalized("error.not.a.number");
            userAnswer = askQuestion(question);
        }
        return userAnswer;
    }

    @Override
    public UserExamination examine(String name, Map<Integer, Question> questionMap) {
        String userName = name;

        System.out.printf("%s, %s", userName, ms.getMessage("test.suggesting", null, curLocale));

        List<ExaminationQuestion> userAnswers = new ArrayList<>();
        for (Question question : questionMap.values()) {
            Answer userAnswer = askQuestion(question);
            userAnswers.add(new ExaminationQuestion(question.getId(), userAnswer.getId(), userAnswer.isCorrect()));
        }

        return new UserExamination(userName, userAnswers);
    }

    @Override
    public void printResult(UserExamination exam) {
        System.out.println("----");
        printLocalized("test.results", exam.getUserName());
        for (ExaminationQuestion userAnswer : exam.getUserQuestions()) {
            System.out.printf("%s %d: %s%n",
                    ms.getMessage("question", null, curLocale),
                    userAnswer.getQuestionId(),
                    userAnswer.isCorrect() ?
                            ms.getMessage("answer.right", null, curLocale) :
                            ms.getMessage("answer.wrong", null, curLocale)
            );
        }
    }

    private void printLocalized(String code) {
        System.out.printf("%s", ms.getMessage(code, null, curLocale));
    }

    private void printLocalized(String code, String param) {
        System.out.println(ms.getMessage(code, new Object[] {param}, curLocale));
    }
}
