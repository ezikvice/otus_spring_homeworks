package ru.ezikvice.springotus.service;

import ru.ezikvice.springotus.domain.Question;
import ru.ezikvice.springotus.domain.UserExamination;

import java.util.Map;

public interface QAService {
    UserExamination examine(Map<Integer, Question> questionMap);

    void printResult(UserExamination exam);
}
