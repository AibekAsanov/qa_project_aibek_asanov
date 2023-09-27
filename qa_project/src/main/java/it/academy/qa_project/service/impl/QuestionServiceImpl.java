package it.academy.qa_project.service.impl;

import it.academy.qa_project.entity.Question;
import it.academy.qa_project.entity.Questionnaire;
import it.academy.qa_project.repository.QuestionRepository;
import it.academy.qa_project.service.QuestionService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuestion(String text, Questionnaire questionnaire) {
        Question question = new Question();
        question.setText(text);
        question.setQuestionnaire(questionnaire);
        return questionRepository.save(question);
    }
    @Override
    public List<Question> getQuestionsByQuestionnaire(Questionnaire questionnaire) {
        return questionRepository.findByQuestionnaire(questionnaire);
    }
    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + id));
    }
}
