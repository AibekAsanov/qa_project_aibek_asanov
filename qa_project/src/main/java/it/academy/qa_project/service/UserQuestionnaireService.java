package it.academy.qa_project.service;

import it.academy.qa_project.entity.Questionnaire;
import it.academy.qa_project.entity.User;
import it.academy.qa_project.entity.UserQuestionnaire;

import java.util.List;

public interface UserQuestionnaireService {
    UserQuestionnaire createUserQuestionnaire(User user, Questionnaire questionnaire);

    List<UserQuestionnaire> getUserQuestionnairesByUser(User user);

    UserQuestionnaire getUserQuestionnaireById(Long id);
}
