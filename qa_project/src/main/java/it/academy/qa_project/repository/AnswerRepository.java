package it.academy.qa_project.repository;

import it.academy.qa_project.entity.Answer;
import it.academy.qa_project.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);
}
