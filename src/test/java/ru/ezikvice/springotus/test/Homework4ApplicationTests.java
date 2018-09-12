package ru.ezikvice.springotus.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.domain.Answer;
import ru.ezikvice.springotus.domain.ExaminationQuestion;
import ru.ezikvice.springotus.domain.Question;
import ru.ezikvice.springotus.domain.UserExamination;
import ru.ezikvice.springotus.service.LoadService;
import ru.ezikvice.springotus.service.QAService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Homework4ApplicationTests {

    @MockBean
    QAService mockQaService;

    @Autowired
    LoadService loadService;

    @Test
    public void testLoad() {
        Map<Integer, Question> questionMap = loadService.loadQuestions();
        Assert.assertTrue(!questionMap.isEmpty());
        Assert.assertEquals(questionMap.size(), 5);
    }

    @Test
    public void testUserExamination() {

        Map<Integer, Question> questionMap = new HashMap<>();

        for (int q = 0; q < 5; q++) {
            Map<Integer, Answer> answers = new HashMap<>();
            for (int a = 0; a < 5; a++) {
                Answer answer = new Answer(a, q, "testAnswer", a % 2 == 0);
                answers.put(a, answer);
            }
            Question question = new Question(q, "test question", answers);
            questionMap.put(q, question);
        }

        List<ExaminationQuestion> questions = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ExaminationQuestion q = new ExaminationQuestion(i, i, i % 2 == 0);
            questions.add(q);
        }
        UserExamination userExamination = new UserExamination("testUser", questions);

        given(this.mockQaService.examine("Test Name", questionMap))
                .willReturn(userExamination);

        UserExamination examineResults = mockQaService.examine("Test Name", questionMap);

        Assert.assertNotNull(examineResults);
        Assert.assertTrue(!examineResults.getUserQuestions().isEmpty());
        Assert.assertEquals(examineResults.getUserQuestions().size(), 5);
    }


}
