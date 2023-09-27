package it.academy.qa_project.repository;

import it.academy.qa_project.entity.User;
import it.academy.qa_project.entity.UserQuestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserQuestionnaireRepository extends JpaRepository<UserQuestionnaire, Long> {
    List<UserQuestionnaire> findByUser(User user);
}
