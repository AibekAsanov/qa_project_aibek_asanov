package it.academy.qa_project.repository;

import it.academy.qa_project.entity.Question;
import it.academy.qa_project.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuestionnaire(Questionnaire questionnaire);
}
