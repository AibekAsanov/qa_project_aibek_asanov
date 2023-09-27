package it.academy.qa_project.controller;

import it.academy.qa_project.entity.Question;
import it.academy.qa_project.entity.Questionnaire;
import it.academy.qa_project.repository.QuestionnaireRepository;
import it.academy.qa_project.service.QuestionService;
import it.academy.qa_project.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @PostMapping("/new")
    public ResponseEntity<?> createQuestion(@RequestParam String text, @RequestParam Long questionnaireId) {
        Questionnaire questionnaire = questionnaireRepository.findById(questionnaireId).orElseThrow(() -> new NoSuchElementException("Not found"));
        Question question = questionService.createQuestion(text, questionnaire);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/questionnaire/{id}")
    public ResponseEntity<List<Question>> getQuestionsByQuestionnaire(@PathVariable Long id) {
        Questionnaire questionnaire = questionnaireService.getQuestionnaireById(id);
        List<Question> questions = questionService.getQuestionsByQuestionnaire(questionnaire);
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionService.getQuestionById(id);
        return ResponseEntity.ok(question);
    }
}
