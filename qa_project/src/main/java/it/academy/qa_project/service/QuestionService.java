package it.academy.qa_project.service;

import it.academy.qa_project.entity.Question;
import it.academy.qa_project.entity.Questionnaire;

import java.util.List;

public interface QuestionService {
    Question createQuestion(String text, Questionnaire questionnaire);

    List<Question> getQuestionsByQuestionnaire(Questionnaire questionnaire);

    Question getQuestionById(Long id);
}
