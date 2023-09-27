package it.academy.qa_project.repository;

import it.academy.qa_project.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire,Long> {
}
