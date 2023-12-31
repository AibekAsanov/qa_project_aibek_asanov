package it.academy.qa_project.service;

import it.academy.qa_project.entity.Questionnaire;
import it.academy.qa_project.entity.enums.TypeAnswer;

import java.util.List;

public interface QuestionnaireService {
    Questionnaire createQuestionnaire(String title, TypeAnswer type);

    List<Questionnaire> getAllQuestionnaires();

    Questionnaire getQuestionnaireById(Long id);

    void delete(Long id);

    Questionnaire update(Long id, String title, TypeAnswer newType);
}
